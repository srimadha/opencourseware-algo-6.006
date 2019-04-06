package com.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sri on 4/5/2019.
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int size = nums.length;
        if( nums == null || size < 3) return results;

        Arrays.sort( nums ); // nlogn

        for( int i=0 ; i < size; i++ ){
            int num = nums[i];
            int left = i + 1;
            int right = size - 1;

            while( left < right ){
                int leftValue = nums[left];
                int rightValue = nums[right];
                if( leftValue + rightValue == - num) {
                    List<Integer> soln = new ArrayList();
                    soln.add(num);
                    soln.add(leftValue);
                    soln.add(rightValue);
                    results.add( soln );

                    while( left < size && leftValue == nums[left] ) left++;
                    while( right > i && rightValue == nums[right] ) right--;
                } else if(leftValue + rightValue > -num ){
                    right --;
                } else {
                    left ++;
                }
            }

            while( i + 1 < size && nums[i + 1] == num ) i++;

        }
        return results;
    }
}
