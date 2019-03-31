package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sri on 3/31/2019.
 *
 * https://leetcode.com/problems/positions-of-large-groups/
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

 For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

 Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

 The final answer should be in lexicographic order.



 Example 1:

 Input: "abbxxxxzzy"
 Output: [[3,6]]
 Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 Example 2:

 Input: "abc"
 Output: []
 Explanation: We have "a","b" and "c" but no large group.
 Example 3:

 Input: "abcdddeeeeaabbbcd"
 Output: [[3,5],[6,9],[12,14]]


 Note:  1 <= S.length <= 1000
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        int cCharCount = 1;
        int prevChar = s.charAt(0);
        List<List<Integer>> list = new ArrayList<>();
        for( int i = 1; i < s.length(); i ++ ){
            if( prevChar == s.charAt(i)){
                cCharCount += 1;
            } else {
                if(cCharCount >=3){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i - 1 - cCharCount + 1);
                    pair.add(i - 1);
                    list.add(pair);

                    cCharCount = 1;
                    prevChar = s.charAt(i);

                } else {
                    cCharCount = 1;
                    prevChar = s.charAt(i);
                }
            }
        }
        if(cCharCount >=3){
            List<Integer> pair = new ArrayList<>();
            pair.add(s.length() - 1 - cCharCount + 1);
            pair.add(s.length() - 1 );
            list.add(pair);
        }
        return list;
    }
}
