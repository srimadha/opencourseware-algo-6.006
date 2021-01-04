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
public class  MoveZeroes
{

        public void moveZeroes(int[] nums) {

            int ind=0,start=0,end=nums.length-1;
            while(ind<=end&&start<end){
                if(nums[ind]!=0){
                    int temp=nums[ind];
                    nums[ind]=nums[start];
                    nums[start]=temp;
                    start++;
                }
                ind++;
            }
        }

}
