package com.leetcode.med;

public class IncreasingTripletSubsequence {
    // https://leetcode.com/problems/increasing-triplet-subsequence/
    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     *
     * Formally the function should:
     *
     * Return true if there exists i, j, k
     * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5]
     * Output: true
     * Example 2:
     *
     * Input: [5,4,3,2,1]
     * Output: false
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] <= first) {
                first = nums[i];
            }
            else if (nums[i] > second) {
                return true;
            }
            else {
                second = nums[i];
            }
        }
        return false;
    }
}
