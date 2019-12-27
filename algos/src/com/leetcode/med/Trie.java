package com.leetcode.med;

import java.util.HashMap;
import java.util.HashSet;

class Trie {

    class Node {
        Node children[] = new Node[26];
        boolean isWord = false;
        char ch;
        Node(){
            this.ch = ' ';
        }
        Node(char ch) {
            this.ch = ch;
        }

        boolean contains( char ch ){
            if( children[ch - 'a'] == null )
                return false;
            else
                return true;
        }
        void putChild( char ch , Node child){
            children[ ch - 'a'] = child;
        }

        Node getChild( char ch ) {
            return children[ ch - 'a'];
        }
        void setIsWord(){
            isWord = true;
        }
        boolean getIsWord(){
            return isWord;
        }
    }
    Node root;

    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for( Character ch : word.toCharArray() ){
            if( !node.contains(ch)){
                node.putChild(ch, new Node( ch ));
            }
            node = node.getChild(ch);
        }
        node.setIsWord();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = search( word, root );
        return node == null ? false : node.getIsWord();
    }

    public Node search( String word, Node root ){
        Node node = root;
        for( Character ch : word.toCharArray() ){
            if( node.contains(ch)){
                node = node.getChild(ch);
            } else {
                return null;
            }
        }
        return node;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = search( prefix, root );
        return node != null;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert( "abc");
        t.insert( "abd");
        System.out.println(t.search("abd"));
        System.out.println(t.startsWith("ab"));
        System.out.println(t.startsWith("b"));
        System.out.println(t.search("abde"));
    }
}
