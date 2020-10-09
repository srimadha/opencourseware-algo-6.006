package com.leetcode.med;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Sri on 4/5/2019.
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

 (Here, the distance between two points on a plane is the Euclidean distance.)

 You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



 Example 1:

 Input: points = [[1,3],[-2,2]], K = 1
 Output: [[-2,2]]
 Explanation:
 The distance between (1, 3) and the origin is sqrt(10).
 The distance between (-2, 2) and the origin is sqrt(8).
 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 Example 2:

 Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 Output: [[3,3],[-2,4]]
 (The answer [[-2,4],[3,3]] would also be accepted.)


 Note:

 1 <= K <= points.length <= 10000
 -10000 < points[i][0] < 10000
 -10000 < points[i][1] < 10000
 */
public class KClosesPointsToOrigin {

    class Solution {

        private double getDist(int[] o1) {
            return Math.pow( o1[0] , 2) + Math.pow(o1[1], 2);
        }

        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    double d1 =  getDist(o1);
                    double d2 = getDist(o2);
                    return d1 == d2 ? 0 : d1 > d2 ? -1 : 1;
                }

                private double getDist(int[] o1) {
                    return Math.pow( o1[0] , 2) + Math.pow(o1[1], 2);
                }
            });

            for(int i=0; i<K; i++){
                pq.offer( points[i]);
            }

            for(int i =K ; i < points.length; i ++ ){
                double d1 = getDist(points[i]);
                double d2 = getDist(pq.peek());

                if( d2 > d1 ){
                    pq.poll();
                    pq.offer( points[i]);
                }
            }

            int results[][] = new int[pq.size()][2];
            for(int i=0; i < K; i++){
                int k[] = pq.poll();
                results[i][0] = k[0];
                results[i][1] = k[1];
            }
            return results;
        }
    }
}
