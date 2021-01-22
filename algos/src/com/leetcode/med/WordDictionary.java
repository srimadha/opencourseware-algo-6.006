package com.leetcode.med;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sri on 1/20/2021.
 */
public class WordDictionary {
    class Trie {
        char ch;
        boolean isWord = false;
        Trie children[] = new Trie[26];

        public Trie(char ch) {
            this.ch = ch;
        }

        public void insertChar(char c) {
            children[c - 'a'] = new Trie(c);
        }

        public void setWord(){
            isWord = true;
        }
    }

    Trie root = new Trie('#');

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    public void addWord(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            boolean isWord = false;

            if( curr.children[ch - 'a'] == null  )
                curr.children[ch - 'a'] = new Trie( ch );
            if (i == word.length() - 1)
                curr.children[ch - 'a'].setWord();

            curr = curr.children[ch - 'a'];
        }

    }

    public boolean search(String word) {
        Trie curr = root;
        Queue<Trie> q = new LinkedList<>();
        char ch = word.charAt(0);
        if( ch == '.'){
            for( Trie n : curr.children ){
                if( n != null )
                    q.offer(n);
            }

        } else {
            if (curr == null || curr.children[ch - 'a'] == null)
                return false;
            //curr = curr.children[ch - 'a'];
            q.offer( curr.children[ch - 'a'] );
        }
        for (int i = 1; i < word.length(); i++) {
            ch = word.charAt(i);

            int size = q.size();

            for( int j = 0; j < size; j++ ){
                curr = q.poll();
                if( ch == '.'){
                    for( Trie n : curr.children ){
                        if( n != null )
                            q.offer(n);
                    }

                } else {
                    if (curr == null || curr.children[ch - 'a'] == null  )
                        return false;
                    q.offer( curr.children[ch - 'a'] );
                }
            }
        }
        while( !q.isEmpty()){
            curr = q.poll();
            if( curr != null){
                if( curr.isWord)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("ab");
        System.out.println( w.search("a"));
    }

}
