package com.leetcode.hard;

import java.util.HashMap;

/**
 * Created by Sri on 4/2/2019.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
public class LRUCache {
    Node head = new Node( -1, -1 );
    Node tail = new Node( -1, -1 );

    HashMap<Integer, Node> map;
    int capacity;

    class Node{
        int key;
        int val;
        Node left;
        Node right;
        public Node( int key, int val ){
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }
    }

    private void removeNode( Node node ){
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void addToTail(Node node){
        node.right = tail;
        node.left = tail.left;
        tail.left.right = node;
        tail.left = node;
    }

    private int removeHead(){
        int key = head.right.key;
        Node secondNode = head.right.right;
        secondNode.left = head;
        head.right = secondNode;
        return key;
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if( map.containsKey(key) ){
            Node node = map.get(key);
            removeNode(node);
            addToTail(node);
            return node.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if( map.containsKey(key) ){
            Node remNode = map.get(key);
            removeNode(remNode);
        }
        else if(map.size() == this.capacity){
            int rkey = removeHead();
            map.remove(rkey);
        }
        addToTail(node);
        map.put(key, node);
    }
}
