package com.leetcode.easy;

import java.util.HashMap;

/**
 * Created by Sri on 3/29/2019.
 * https://leetcode.com/problems/isomorphic-strings/
 *
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 Example 1:

 Input: s = "egg", t = "add"
 Output: true
 Example 2:

 Input: s = "foo", t = "bar"
 Output: false
 Example 3:

 Input: s = "paper", t = "title"
 Output: true
 Note:
 You may assume both s and t have the same length.
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();
        if( s.length() != t.length() ) return false;

        for( int i = 0; i < s.length(); i ++ ){
            if( !charMap.containsKey(s.charAt(i) ) ) {
                if( charMap.containsValue(t.charAt(i)) )
                    return false;
                charMap.put( s.charAt(i), t.charAt(i));
            } else {
                if( charMap.get(s.charAt(i)) != t.charAt(i)  )
                    return false;
            }
        }

        return true;
    }
}
