package com.leetcode.med;

/**
 * Created by Sri on 4/18/2019.
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if( s == null || s.length() == 0 ) return "";

        int start = 0, end = 0;

        for( int i=0; i < s.length(); i++ ){
            int len1 = expandAroundCenter(s ,i ,i);
            int len2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);

            if( len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring( start, end + 1);
    }

    int expandAroundCenter( String s, int L, int R){
        while( L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }
}
