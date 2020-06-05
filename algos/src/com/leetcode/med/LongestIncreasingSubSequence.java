package com.leetcode.med;

/**
 * Created by Sri on 6/4/2020.
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        if( nums.length == 0 )
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for(int i=1; i<nums.length; i++){
            int maxVal = 0;
            for(int j=0; j<i; j++){
                if( nums[i] > nums[j]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
