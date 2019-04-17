package com.leetcode.med;

import java.util.PriorityQueue;

/**
 * Created by Sri on 4/14/2019.
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 *
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.offer( nums[i]);
        }

        for( int i = k ; i< nums.length; i ++){
            if( pq.peek() <= nums[i]){
                pq.remove();
                pq.add( nums[i]);
            }
        }

        return pq.peek();
    }
}
