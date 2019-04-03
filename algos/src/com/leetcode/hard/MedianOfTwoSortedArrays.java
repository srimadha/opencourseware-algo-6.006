package com.leetcode.hard;

/**
 * Created by Sri on 4/2/2019.
 *
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *

 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] input1, int[] input2) {

        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        if (x == 0) {
            int mid = y / 2;
            if (y % 2 == 0) {
                return (double) (input2[mid] + input2[mid - 1]) / 2.0;
            } else {
                return (double) (input2[mid]);
            }
        }
        int low = 0;
        int high = x;
        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (x + y + 1) / 2 - partX;
            int maxLeftX = partX == 0 ? Integer.MIN_VALUE : input1[partX - 1];
            int minRightX = partX == x ? Integer.MAX_VALUE : input1[partX];

            int maxLeftY = partY == 0 ? Integer.MIN_VALUE : input2[partY - 1];
            int minRightY = partY == y ? Integer.MAX_VALUE : input2[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
