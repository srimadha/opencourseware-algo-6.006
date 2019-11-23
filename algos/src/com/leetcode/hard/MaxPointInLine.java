package com.leetcode.hard;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MaxPointInLine {

    public int maxPoints(int[][] points) {
        HashMap<String, Integer> slopeCount = new HashMap<>();
        int maxCount = 0;

        for( int i = 0; i < points.length; i++ ) {
            int[] b = points[i];
            int localMax = 0;
            for( int j = 0; j < points.length; j++ ) {
                int []e = points[j];
                if( i != j  && (b[0] == e[0] && b[1] == e[1])){
                    localMax += 1;
                } else if( i != j /*&& !( b[0] == e[0] && b[1] == e[1])*/){
                    String slope = getSlope( b, e );
                    slopeCount.put( slope, slopeCount.getOrDefault(slope, 0) + 1);
                    localMax = Math.max( localMax, slopeCount.getOrDefault(slope, 0) );
                }

            }
            //System.out.println( localMax + 1);
            maxCount = Math.max( localMax+1, maxCount );
            slopeCount.clear();

        }
        return maxCount;
    }

    private int gcd( int a , int b){
        return b == 0 ? a : gcd( b, a%b);
    }

    private String getSlope( int a[], int b[]){
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        int gcd = gcd( x, y);
        return x/gcd + "#" + y/gcd;
    }

}
