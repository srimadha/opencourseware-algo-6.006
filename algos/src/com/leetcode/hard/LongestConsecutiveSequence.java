package com.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sri on 4/9/2019.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums){
            set.add(num);
        }

        int longestStreak = 0;

        for(int num : nums){
            if(! set.contains(num-1)){
                int currentStreak = 1;
                int currentNum = num;

                while( set.contains(currentNum + 1) ){

                    currentNum += 1;
                    currentStreak += 1;

                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
