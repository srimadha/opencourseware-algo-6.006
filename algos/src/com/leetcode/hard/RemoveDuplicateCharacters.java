package com.leetcode.hard;

import java.util.Stack;

/**
 * Created by Sri on 4/27/2019.
 *
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 *
 *
 Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 Example 1:

 Input: "bcabc"
 Output: "abc"
 Example 2:

 Input: "cbacdcbc"
 Output: "acdb"
 */
public class RemoveDuplicateCharacters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int count[] = new int[26];
        boolean added[] = new boolean[26];

        for( char ch : s.toCharArray( ) ){
            count[ ch - 'a']++;
        }
        for( char ch : s.toCharArray( ) ){
            count[ ch - 'a']--;

            if( added[ch - 'a'])
                continue;

            while( !stack.isEmpty() && stack.peek() > ch && count[ stack.peek() - 'a'] > 0){
                added[ stack.pop() - 'a'] = false;
            }

            stack.push( ch );
            added[ ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ){
            sb.append( stack.pop() );
        }
        return sb.reverse().toString();
    }
}
