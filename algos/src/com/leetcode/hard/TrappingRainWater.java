package com.leetcode.hard;

/**
 * Created by Sri on 4/3/2019.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax[] = new int[ height.length ];
        int lMax = Integer.MIN_VALUE;
        for(int i=0; i<height.length ; i++){
            if( lMax < height[i])
                lMax = height[i];
            leftMax[i] = lMax;
        }

        int rMax = Integer.MIN_VALUE;
        int trap = 0;
        for(int i = height.length - 1; i >=0 ; i--){
            int maxLength = Math.min(leftMax[i], rMax );
            if(maxLength > 0){
                if( maxLength - height[i] > 0 ){
                    trap += maxLength - height[i];
                }
            }

            if( rMax < height[i])
                rMax = height[i];
        }

        return trap;

    }
}
