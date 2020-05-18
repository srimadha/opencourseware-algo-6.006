package com.leetcode.med;

/**
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int bs = binarySearch( nums, target, 0, nums.length - 1 );
        System.out.println( bs );
        int left = getBoundary( nums, target, bs, 1);
        int right = getBoundary( nums, target, bs, -1);
        return new int[]{right, left};
    }
    public int getBoundary( int[] nums, int target, int j, int sign ){
        if( j == -1) return -1;
        while( j >=0 && j < nums.length ){
            if( sign > 0 ) {
                if( nums[j] == target ){
                    j++;
                } else {
                    return j - 1;
                }
            } else {
                if( nums[j] == target ){
                    j--;
                } else {
                    return j + 1;
                }
            }
        }
        if( sign > 0){
            return nums.length - 1;
        } else {
            return 0;
        }
    }
    public int binarySearch( int []nums, int target, int l, int r ){
        if( l > r ){
            return -1;
        }
        int mid = (l + r)/2;
        if( nums[mid] == target)
            return mid;
        if( nums[mid] > target ) {
            return binarySearch( nums, target, l, mid-1 );
        } else {
            return binarySearch( nums, target, mid + 1, r );
        }
    }
}
