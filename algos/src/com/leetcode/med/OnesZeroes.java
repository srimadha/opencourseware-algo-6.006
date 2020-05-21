package com.leetcode.med;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 *
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 * Note:
 *
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 *
 *
 * Example 1:
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 *
 *
 * Example 2:
 *
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 */
public class OnesZeroes {

    public  static int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for(String str : strs ){
            int mc = 0;
            int nc = 0;
            for( char c : str.toCharArray() ){
                if( c == '0'){
                    mc++;
                } else {
                    nc++;
                }
            }

            for(int zero=m; zero >= mc; zero-- ){
                for(int one=n; one>=nc; one-- ){
                    dp[zero][one] = Math.max(dp[zero][one],
                            1 + dp[zero - mc][one - nc]);
                }
            }


        }
        return dp[m][n];

    }

    public static void main(String args[]){
        String strs[] = new String[]{"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        findMaxForm(strs, m, n);
    }


}
