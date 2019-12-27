package com.leetcode.med;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinPathSum {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            if( m == 0) return 0;
            int n = grid[0].length;

            int dp[][] = new int[m][n];

            for( int i=0; i<m; i++ ){
                dp[i][0] = (i > 0 ? dp[i-1][0] : 0) + grid[i][0];
            }

            for( int j=0; j<n; j++ ){
                dp[0][j] = (j > 0 ? dp[0][j-1] : 0) + grid[0][j];
            }

            for( int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if( i == 0 || j == 0 ){
                        //System.out.print( dp[i][j] + " ");
                    } else {
                        dp[i][j] = Math.min( dp[i-1][j],
                                dp[i][j-1]) + grid[i][j];
                        //System.out.print( dp[i][j] + " ");
                    }
                }
                //System.out.println();
            }

            return dp[m-1][n-1];
        }

}
