package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 4/6/2019.
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Example 1:

 Input: "()())()"
 Output: ["()()()", "(())()"]
 Example 2:

 Input: "(a)())()"
 Output: ["(a)()()", "(a())()"]
 Example 3:

 Input: ")("
 Output: [""]
 */
public class RemoveParentheses {
    boolean isParenthesis(char c)
    {
        return ((c == '(') || (c == ')'));
    }


    boolean isValidString(String str)
    {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    String stripParen( String s){
        String res = "";
        for (int i = 0; i < s.length(); i++)
        {
            if( !isParenthesis(s.charAt(i))){
                res = res + s.charAt(i);
            }
        }
        return res;
    }

    public List<String> removeInvalidParentheses(String str) {
        List<String> soln = new ArrayList<>();
        HashSet<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(str);
        visit.add(str);
        int level = 0;
        while( q.size() != 0){
            String s = q.poll();

            if( isValidString(s) ) {
                if( level <= s.length()){
                    soln.add( s );
                    level = s.length();
                }
            } else if( level < s.length() ){
                for(int i=0; i< s.length(); i++){
                    if( isParenthesis(s.charAt(i))){

                        String sp = s.substring(0,i) + s.substring(i+1);
                        if( !visit.contains(sp)){
                            q.add(sp);
                            visit.add(sp);
                        }
                    }
                }
            }

        }
        if(soln.size() == 0){
            soln.add(stripParen(str));
        }
        return soln;
    }
}
