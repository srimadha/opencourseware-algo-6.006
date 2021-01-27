package com.leetcode.med;

/**
 * Created by Sri on 1/27/2021.
 *
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".


 Example 2:

 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


 Note:

 The input string length won't exceed 1000.
 */
public class CountPalindromicSubStrings {
    public static int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expand(str, n, i, i);
            count += expand(str, n, i, i+1);
        }

        return count;
    }

    protected static int expand(char[] str, int n, int i, int j) {
        int cnt = 0;

        while (i >= 0 && j < n && str[i] == str[j]) {
            cnt++;
            i--;
            j++;
        }

        return cnt;
    }
}
