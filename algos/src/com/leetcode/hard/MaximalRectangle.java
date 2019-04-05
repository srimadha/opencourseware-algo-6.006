package com.leetcode.hard;

import java.util.Stack;

/**
 * Created by Sri on 4/4/2019.
 *
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example:

 Input:
 [
 ["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]
 ]
 Output: 6
 */
public class MaximalRectangle {
    // O( n~2 M )
    public int maximalRectangle1(char[][] matrix) {
        if( matrix.length == 0) return 0;
        int maxArea = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for( int i = 0; i<m ; i ++)
            for( int j = 0; j<n ;j++)
                if( matrix[i][j] == '1'){
                    dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;
                    int width = dp[i][j];

                    for( int k = i; k >=0 ; k--){
                        width = Math.min( width, dp[k][j]);
                        maxArea = Math.max( maxArea, width * ( i - k + 1));
                    }
                }

        return maxArea;
    }

    public int maxRectangleInHistogram(int heights[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        for( int i = 0; i< heights.length ; i++){
            while( stack.peek()!=-1 && heights[stack.peek()] >= heights[i])
                area = Math.max( area,
                        heights[stack.pop()] * ( i - stack.peek() - 1 ) );
            stack.push(i);
        }
        while( stack.peek()!=-1)
            area = Math.max( area,
                    heights[stack.pop()] * ( heights.length - stack.peek() - 1 ) );

        return area;

    }

    public int maximalRectangleStack(char[][] matrix) {
        if( matrix.length == 0 ) return 0;
        int area = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n];

        for( int i = 0; i < m ; i++ ){
            for( int j = 0; j < n; j++ )
                dp[j] = matrix[i][j] == '1' ?  dp[j] + 1 : 0;
            area = Math.max( area, maxRectangleInHistogram( dp ) );
        }
        return area;
    }
}
