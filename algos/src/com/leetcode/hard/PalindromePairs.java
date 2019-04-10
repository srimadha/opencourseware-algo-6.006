package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sri on 4/7/2019.
 *
 * https://leetcode.com/problems/palindrome-pairs/submissions/
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:

 Input: ["abcd","dcba","lls","s","sssll"]
 Output: [[0,1],[1,0],[3,2],[2,4]]
 Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 Example 2:

 Input: ["bat","tab","cat"]
 Output: [[0,1],[1,0]]
 Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
    public boolean isPalindrome( String comp ){
        int i = 0;
        int j = comp.length()-1;
        while( i <= j){
            if( comp.charAt(i) != comp.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public String reverse( String part ){
        return new StringBuilder( part ).reverse().toString();
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> soln = new ArrayList<>();
        if (words == null || words.length < 2) return soln;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i < words.length; i++){
            map.put( words[i], i);
        }
        for(int i=0; i < words.length; i++){
            for( int j = 0; j <= words[i].length(); j++){
                String firstPart = words[i].substring(0, j);
                String secondPart = words[i].substring(j );


                if( isPalindrome(firstPart)){
                    int index = map.getOrDefault( reverse(secondPart), -1);
                    if( index != -1 && index != i ){
                        soln.add( Arrays.asList( index, i ));
                    }
                }

                if( isPalindrome(secondPart) && secondPart.length()!=0){
                    int index = map.getOrDefault( reverse(firstPart), -1);
                    if( index != -1 && index != i ){
                        soln.add( Arrays.asList( i, index ));
                    }
                }

            }
        }
        return soln;

    }
}
