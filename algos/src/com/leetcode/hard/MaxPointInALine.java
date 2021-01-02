package com.leetcode.hard;

import java.util.HashMap;

/**
 * Created by Sri on 10/9/2020.
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Example 1:

 Input: [[1,1],[2,2],[3,3]]
 Output: 3
 Explanation:
 ^
 |
 |        o
 |     o
 |  o
 +------------->
 0  1  2  3  4
 Example 2:

 Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 Output: 4
 Explanation:
 ^
 |
 |  o
 |     o        o
 |        o
 |  o        o
 +------------------->
 0  1  2  3  4  5  6
 NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointInALine {

    private int gcd( int a, int b){
        return b == 0 ? a : gcd( b, a%b );
    }

    private String getSlope( int[] pointA, int[] pointB ){
        int gcd = gcd( pointA[0] - pointB[0], pointA[1] - pointB[1]);
        return (pointA[0] - pointB[0])/gcd + "#" + (pointA[1] - pointB[1])/gcd;
    }

    public int maxPoints(int[][] points) {

        HashMap<String, Integer> slopeCount = new HashMap<>();
        int ans = 0;

        for( int i=0; i<points.length; i ++ ){
            int localAns = 0;
            for( int j = 0; j < points.length; j++ ){
                if( i != j ) {
                    String slope = getSlope(points[i], points[j]);
                    slopeCount.put( slope, slopeCount.getOrDefault(slope, 0) + 1);

                    localAns = Math.max( localAns, slopeCount.get(slope));

                }
            }
            ans = Math.max( ans, localAns + 1);
            slopeCount.clear();
        }

        return ans;
    }
}
