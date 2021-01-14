package com.leetcode.med;

/**
 * Created by Sri on 4/7/2019.
 */
public class NextPermutation {

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public void nextPermutation(int[] nums) {
        int last = nums.length - 2;

        while (last >= 0 && nums[last] >= nums[last + 1]) last--;

        if (last >= 0) {
            int swap = nums.length - 1;
            while (swap >= 0 && nums[swap] <= nums[last]) swap--;
            swap(nums, last, swap);
        }
        reverse(nums, last + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int n[] = new int[] { 8, 1, 5, 4 };
        np.nextPermutation( n );
        for (int i = 0; i < n.length; i++) {
            System.out.print( n[i]);
        }
    }
}
