package com.leetcode.med;

/**
 * Created by Sri on 1/3/2021.
 */
/*

https://leetcode.com/problems/maximal-square/


Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.



Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        int dp[][] = new int[ rows + 1 ][ cols + 1];
        int max = 0;
        for( int i = 1; i <= rows; i++)
            for( int j = 1; j <= cols; j++ ){
                if( matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min( dp[ i - 1 ][ j - 1 ],
                            Math.min( dp[ i - 1 ][ j ], dp[i][ j - 1])) + 1;
                    max = Math.max( dp[i][j], max);
                }
            }

        return max * max;
    }
}
