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

        public List<String> generateParenthesis2(int n) {
            List<String> soln = new ArrayList<String>();
            soln.add("");
            return  generateParenthesis( n, n, soln);
        }

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            StringBuilder str = new StringBuilder();
            dfs(n, n, result, str);
            return result;
        }

        public void dfs(int left, int right, List<String> result, StringBuilder str){

            //basecase
            if(left==0 && right==0){
                result.add(str.toString());
            }
            //general case
            if(left > 0){  //add left
                str.append('(');
                dfs(left-1, right, result, str);
                str.deleteCharAt(str.length() - 1);
            }
            if(right > left){
                str.append(')');
                dfs(left, right-1, result, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
