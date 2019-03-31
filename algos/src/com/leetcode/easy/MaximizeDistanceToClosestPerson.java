package com.leetcode.easy;

import java.util.*;
/**
 *
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

 There is at least one empty seat, and at least one person sitting.

 Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

 Return that maximum distance to closest person.

 Example 1:

 Input: [1,0,0,0,1,0,1]
 Output: 2
 Explanation:
 If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 If Alex sits in any other open seat, the closest person has distance 1.
 Thus, the maximum distance to the closest person is 2.
 Example 2:

 Input: [1,0,0,0]
 Output: 3
 Explanation:
 If Alex sits in the last seat, the closest person is 3 seats away.
 This is the maximum distance possible, so the answer is 3.
 Note:

 1 <= seats.length <= 20000
 seats contains only 0s or 1s, at least one 0, and at least one 1.
 *
 * Created by Sri on 3/31/2019.
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill( left, length );
        Arrays.fill( right, length );

        for( int i=0; i<length ; i++){
            if( seats[i] == 1 ){
                left[i] = 0;
            } else if(i > 0){
                left[i] = left[i-1] + 1;
            }
        }

        for( int i=length-1; i>=0 ; i--){
            if( seats[i] == 1 ){
                right[i] = 0;
            } else if(i < length - 1){
                right[i] = right[i + 1] + 1;
            }
        }
        int displacement = -1;
        for( int i=0; i<length ; i++){
            int minD = Math.min( left[i], right[i]);
            if( minD > displacement ){
                displacement = minD;
            }
        }
        return displacement;
    }
}
