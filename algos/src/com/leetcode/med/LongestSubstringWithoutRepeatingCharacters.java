package com.leetcode.med;

import java.util.HashSet;

/**
 * Created by Sri on 4/20/2019.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        int max = 0;
        for(int r=0;r<s.length();r++){
            Character ch = s.charAt(r);
            if( !set.contains(ch) ){
                set.add( ch );
                max = Math.max(max, set.size());
            } else {
                while( set.contains(ch) && l < r ){
                    Character toRemove = s.charAt(l);
                    l++;
                    set.remove(toRemove);
                    max = Math.max(max, set.size());
                }
                set.add(ch);
            }
        }
        return max;
    }
}
