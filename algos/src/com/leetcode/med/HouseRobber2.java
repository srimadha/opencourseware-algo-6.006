package com.leetcode.med;

/**
 * Created by Sri on 1/6/2021.
 *
 * https://leetcode.com/problems/house-robber-ii/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



 Example 1:

 Input: nums = [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if( nums == null || nums.length == 0 ) return 0;
        if( nums.length == 1) return nums[0];
        if( nums.length == 2 ) return Math.max( nums[0], nums[1]);

        int max1 = robSimple(nums, 0, nums.length - 2);
        int max2 = robSimple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);

    }
    public int robSimple(int[] nums, int start, int end) {

        int t1 = 0;
        int t2 = 0;
        for( int i = start; i <= end ; i++ ){
            int temp = t1;
            int current = nums[i];
            t1 = Math.max( current + t2, t1 );
            t2 = temp;
        }

        return t1;
    }
}
