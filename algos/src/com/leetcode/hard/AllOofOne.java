package com.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 *
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOofOne {
    class Node {
        int count;
        Node left, right;
        HashSet<String> keys;

        public Node(int count, HashSet<String> keys) {
            this.count = count;
            this.keys = keys;
        }
    }

    class DLL {
        Node head;
        Node tail;

        public DLL() {
            head = new Node(0, new HashSet<>());
            tail = new Node(0, new HashSet<>());
            head.right = tail;
            tail.left = head;
        }

        public Node decrementNode( Node node, int count, String key ) {
            node.keys.remove(key);
            if( node.keys.size() == 0 ){
                node.left.right = node.right;
                node.right.left = node.left;
            }
            node = node.left;
            if( count == 0 ){
                return null;
            } else {
                if( node.count == count ){
                    node.keys.add(key);
                    return node;
                } else {
                    HashSet<String> keys = new HashSet<>();
                    keys.add(key);
                    Node newNode = new Node(count, keys);
                    newNode.left = node;
                    newNode.right = node.right;
                    node.right = newNode;
                    newNode.right.left = newNode;
                    return newNode;
                }
            }
        }

        public Node addNodeToHead( String key ){

            Node firstNode = head.right;
            if( firstNode.count == 1){
                firstNode.keys.add(key);
                return firstNode;
            } else {
                HashSet<String> keys = new HashSet<>();
                keys.add(key);
                Node newNode = new Node(1 , keys);
                head.right = newNode;
                newNode.left = head;
                newNode.right = firstNode;
                firstNode.left = newNode;
                return newNode;
            }

        }

        public Node incrementNode( Node node, int count, String key ) {
            if( node == null ){
                return addNodeToHead( key );
            } else {
                node.keys.remove( key );
                if( node.right.count == count ){
                    node.right.keys.add(key);
                    if( node.keys.size() == 0 ) {
                        node.left.right = node.right;
                        node.right.left = node.left;
                    }
                    return node.right;
                } else {
                    HashSet<String> keys = new HashSet<>();
                    keys.add(key);
                    Node newNode = new Node(count , keys);
                    newNode.right = node.right;
                    node.right.left = newNode;
                    newNode.left = node;
                    node.right = newNode;
                    if( node.keys.size() == 0){
                        newNode.left = node.left;
                        node.left.right = newNode;
                    }
                    return newNode;
                }
            }
        }

    }

    DLL dll;
    HashMap<String, Node> keyMap;

    /**
     * Initialize your data structure here.
     */
    public AllOofOne() {
        keyMap = new HashMap<>();
        dll = new DLL();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Node node = null;
        if (keyMap.containsKey(key)) {
            Node nodeKey = keyMap.get(key);
            node = dll.incrementNode(nodeKey, nodeKey.count + 1, key);
        } else {
            node = dll.incrementNode(null, 1, key);
        }
        keyMap.put(key, node);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Node node = null;
        if (keyMap.containsKey(key)) {
            Node nodeKey = keyMap.get(key);
            node = dll.decrementNode(nodeKey, nodeKey.count - 1, key);
            if (node != null)
                keyMap.put(key, node);
            else
                keyMap.remove(key);
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        HashSet<String> keys = dll.tail.left.keys;
        return keys.size() > 0 ? keys.iterator().next() : "";
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        HashSet<String> keys = dll.head.right.keys;
        return keys.size() > 0 ? keys.iterator().next() : "";
    }

    public static void main(String[] args) {
        AllOofOne allOofOne = new AllOofOne();
        allOofOne.inc("hello");
        allOofOne.inc("hello");
        System.out.println(allOofOne.getMaxKey());
        System.out.println(allOofOne.getMinKey());
        allOofOne.inc("leet");
        System.out.println(allOofOne.getMaxKey());
        System.out.println(allOofOne.getMinKey());
    }

}
