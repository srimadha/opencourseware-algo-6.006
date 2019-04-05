package com.leetcode.hard;

import java.util.Stack;

/**
 * Created by Sri on 4/4/2019.
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
 Example:

 Input: [2,1,5,6,2,3]
 Output: 10
 */
public class FindLargestRectangleInHistogram {
    public int findMinIndex(int[] heights, int start, int end){
        int minIndex = start;
        int min = heights[minIndex];
        for( int i = start+1; i<= end; i++){
            if( min > heights[i]){
                min = heights[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int largestRectangleArea(int[] heights, int start, int end) {
        if( start > end ) return 0;

        int minIndex = findMinIndex(heights, start, end);

        return Math.max( heights[minIndex] * ( end - start + 1),
                Math.max(largestRectangleArea( heights, start, minIndex - 1 ),
                        largestRectangleArea( heights, minIndex + 1, end )));


    }

    public int largestRectangleArea(int[] heights) {

        return largestRectangleArea( heights, 0, heights.length - 1 );
    }

    public int largestRectangleAreaStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;
        for( int i=0; i<heights.length; i++){
            while( stack.peek() != -1 && heights[stack.peek()] >= heights[i] ){
                area = Math.max( area,
                        heights[stack.pop()] * (i-stack.peek() - 1));
            }
            stack.push(i);
        }
        while( stack.peek() != -1 ){
            area = Math.max( area,
                    heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return area;
    }
}
