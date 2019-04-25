package com.leetcode.med;

/**
 * Created by Sri on 4/24/2019.
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Example 1:

 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        if( nums.length == 1 ) return nums[0];
        boolean isZerSoln = isZeroSoln(nums);
        if( isZerSoln ) return 0;

        int maxSoFar = 1;
        int maxEndHere = 1;
        int minEndHere = 1;

        for( int i=0; i< nums.length; i++){

            if( nums[i] > 0 ){
                maxEndHere = maxEndHere * nums[i];
                minEndHere = Math.min( minEndHere * nums[i] , 1);
            } else if( nums[i] == 0 ){
                maxEndHere = 1;
                minEndHere = 1;
            } else {
                int prevMax = maxEndHere;
                maxEndHere = Math.max(minEndHere* nums[i], 1);
                minEndHere = prevMax * nums[i];
            }

            maxSoFar = Math.max( maxSoFar, maxEndHere);
        }

        return maxSoFar;
    }

    private boolean isZeroSoln(int[] nums) {
        boolean isZero = false;
        boolean isPositive = false;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0) isZero = true;
            if(nums[i] > 0) isPositive = true;
            if( i > 0 ){
                if( nums[i] < 0 && nums[i-1] < 0 ){
                    isPositive = true;
                }
            }
        }
        return isPositive == false && isZero == true;
    }
}
