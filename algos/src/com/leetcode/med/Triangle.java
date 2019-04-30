package com.leetcode.med;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sri on 4/28/2019.
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:

 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


 https://leetcode.com/problems/triangle/


 */
public class Triangle {
    HashMap<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle, int row, int col) {
        String key = row + "-" + col;
        if (map.containsKey(key)) return map.get(key);
        int soln;
        if (row + 1 == triangle.size()) {
            soln = triangle.get(row).get(col);
        } else {
            soln = Math.min(minimumTotal(triangle, row + 1, col), minimumTotal(triangle, row + 1, col + 1)) + triangle.get(row).get(col);
        }
        map.put(key, soln);
        return map.get(key);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int row = 0, col = 0;
        return minimumTotal(triangle, row, col);
    }
}
