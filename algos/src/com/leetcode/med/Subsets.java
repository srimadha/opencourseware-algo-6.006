package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sri on 11/21/2019.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> toAdd = new ArrayList<List<Integer>>();
            for (List<Integer> lst : ans) {
                List<Integer> newLst = new ArrayList<Integer>(lst);
                newLst.add(num);
                toAdd.add(newLst);
            }
            ans.addAll(toAdd);
        }
        return ans;
    }
}
