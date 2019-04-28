package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sri on 4/27/2019.
 *
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target,int index, List<Integer> soln ) {
        List<List<Integer>> result = new ArrayList<>();
        if( target == 0 ){
            result.add( soln );
            return result;
        }

        if( target < 0 || index + 1 > candidates.length ){
            return result;
        }
        List<Integer> includeSoln = new ArrayList<>(soln);
        includeSoln.add( candidates[index] );
        List<List<Integer>> include = combinationSum( candidates, target - candidates[index],index, includeSoln );

        List<Integer> excludeSoln = new ArrayList<>(soln);
        List<List<Integer>> exclude = combinationSum( candidates, target,index + 1, excludeSoln );
        if( include.size() > 0)
            result.addAll( include );
        if( exclude.size() > 0)
            result.addAll( exclude );

        return result;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0, new ArrayList<>());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }

            return;
        }

        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
