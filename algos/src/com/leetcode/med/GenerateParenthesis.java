package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sri on 4/4/2019.
 *
 * https://leetcode.com/problems/generate-parentheses/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParenthesis {
    class Solution {

        List<String> addToList(List<String> soln, char ch){
            return soln.stream().map( str -> { return( str + ch); }).collect(Collectors.toList());
        }

        List<String>  generateParenthesis( int l, int r, List<String> soln){
            List<String> finalSoln = new ArrayList<>();
            if( l==0 && r==0 ) return soln;
            else if( l < r && l > 0){
                List<String> lsoln = generateParenthesis(l-1, r, addToList( soln , '('));
                List<String> rsoln = generateParenthesis(l, r-1, addToList( soln , ')'));
                finalSoln.addAll(lsoln);
                finalSoln.addAll(rsoln);
            } else if( l==r ){
                List<String> lsoln = generateParenthesis(l-1, r, addToList( soln , '('));
                finalSoln.addAll(lsoln);
            } else if(r > 0){
                List<String> rsoln = generateParenthesis(l, r-1, addToList( soln , ')'));
                finalSoln.addAll(rsoln);
            }
            return finalSoln;
        }

        public List<String> generateParenthesis(int n) {
            List<String> soln = new ArrayList<String>();
            soln.add("");
            return  generateParenthesis( n, n, soln);
        }
    }
}
