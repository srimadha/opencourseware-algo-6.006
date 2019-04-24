package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sri on 4/23/2019.
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for( int num : nums ){
            int val = Math.abs( num ) - 1;
            if( nums[val] > 0 ){
                nums[val] = - nums[val];
            }
        }

        List<Integer> soln = new ArrayList<>();

        for( int i= 0; i<nums.length; i++ ){
            if( nums[i] > 0 ){
                soln.add(i+1);
            }
        }
        return soln;
    }
}
