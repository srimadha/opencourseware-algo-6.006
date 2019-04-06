package com.leetcode.easy;

/**
 * Created by Sri on 4/5/2019.
 *

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeroes
{

        public void moveZeroes(int[] nums) {

            for( int i = 0; i< nums.length; i++){

                if( nums[i] == 0 ){
                    int j = i + 1;
                    while( j < nums.length && nums[j] == 0 ){
                        j++;
                    }
                    if( j < nums.length){
                        nums[i] = nums[j];
                        nums[j] = 0;
                    }
                }

            }
        }

}
