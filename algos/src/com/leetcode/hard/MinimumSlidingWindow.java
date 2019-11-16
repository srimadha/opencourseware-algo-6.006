package com.leetcode.hard;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class MinimumSlidingWindow {
    class Pair implements Comparable<Pair> {
        int num;
        int index;

        public Pair( int num, int index ){
            this.num = num;
            this.index = index;
        }

        public int getNum() {
            return this.num;
        }

        @Override
        public int compareTo( Pair p ){
            if( this.num > p.num ) return -1;
            else if( this.num < p.num ) return 1;
            else return 0;
        }

        @Override
        public boolean equals( Object o){
            if( o instanceof Pair ){
                Pair p = (Pair) o;
                return num == p.num && index == p.index;
            } else {
                return false;
            }
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums.length == 0){
            return new int[0];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int start = 0;
        int end = k;
        int result[] = new int[nums.length - k + 1];
        int index = 0;
        for( int i=0; i<k ;i++){
            pq.add(new Pair(nums[i], i));
        }
        for( ;end < nums.length; end++ ){
            result[index++] = pq.peek().getNum();
            pq.remove( new Pair(nums[start], start++));
            pq.add( new Pair(nums[end], end));
        }
        result[index++] = pq.peek().getNum();
        return result;
    }

    //O(N)
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if(len==0 || k==0 || len<k) return new int[0];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int res [] = new int[len-k+1];
        int resC = 1;
        int end = 0;

        while(end<len){
            if(end<k){
                if(nums[end]>max){
                    max = nums[end];
                    maxIndex = end;
                }
                res[0] = max;
            }
            else{
                if(maxIndex<end-k+1){
                    max = Integer.MIN_VALUE;
                    for(int j = maxIndex+1; j<=end; j++) {
                        if(nums[j]>max){
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                }
                else {
                    if(nums[end]>max) {
                        max = nums[end];
                        maxIndex = end;
                    }
                }
                res[resC++] = max;
            }
            end++;
        }
        return res;
    }
}

