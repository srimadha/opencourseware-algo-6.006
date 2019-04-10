package com.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sri on 4/7/2019.
 *
 * https://leetcode.com/problems/permutations/
 *
 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {
    public List<List<Integer>> insert(List<List<Integer>> soln, int num ){
        List<List<Integer>> temp = new ArrayList<>();
        soln.forEach( k -> {

            for( int i = 0; i < k.size() + 1; i++ ){
                ArrayList<Integer> part1 = new ArrayList( k.subList(0, i) );
                ArrayList<Integer> part2 = new ArrayList( k.subList(i, k.size()) );
                ArrayList<Integer> x = new ArrayList<>();
                x.add(num);
                part1.addAll( x );
                part1.addAll( part2 );
                temp.add( part1 );
            }


        });
        return temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> soln = new ArrayList<>();

        soln.add( Arrays.asList(nums[0]));
        for( int i=1; i< nums.length; i++){
            soln = insert( soln, nums[i]);
        }

        return soln;
    }
}
