package com.leetcode.med;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for(int i=1 ; i<nums.length; i++){
            if( nums[i-1] > 0 ){
                nums[i] += nums[i-1];
            }
            max = Math.max( nums[i], max);
        }
        return max;
    }
}
