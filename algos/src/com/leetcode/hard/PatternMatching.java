package com.leetcode.hard;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/regular-expression-matching/submissions/
 * Created by Sri on 3/30/2019.
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * *
 * Note:
 * *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class PatternMatching {
    public boolean isMatch(String text, String pattern) {
        if( pattern.isEmpty() ) return text.isEmpty();

        boolean firstMatch = !text.isEmpty() && ( text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.' );

        if( pattern.length() >=2 && pattern.charAt(1) == '*' ){
            return isMatch( text, pattern.substring(2) ) || firstMatch && isMatch( text.substring(1), pattern );
        } else {
            return firstMatch && isMatch( text.substring(1), pattern.substring(1) );
        }

    }

    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String text, String pattern, int i, int j){
        if( !map.containsKey(i+""+j)){
            boolean soln;
            if( j == pattern.length()) {
                soln = text.length() == i;
            } else {
                boolean firstMatch = i < text.length() && ( text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.' );

                if( pattern.length() > j + 1 && pattern.charAt(j + 1) == '*' ){
                    soln =  isMatch( text, pattern, i, j+2 ) || (firstMatch && isMatch( text, pattern, i+1, j));
                } else {
                    soln = firstMatch && isMatch( text, pattern, i+1, j+1);
                }
            }
            map.put(i+""+j, soln);
        }
        return map.get(i+""+j);
    }
}
