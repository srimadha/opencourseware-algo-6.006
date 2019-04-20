package com.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sri on 4/18/2019.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 Example:
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {
    public List<String> charNumMapping( Character digit ){
        switch( digit ){
            case '2': return Arrays.asList(new String[] { "a", "b", "c" });
            case '3': return Arrays.asList(new String[] { "d", "e", "f" });
            case '4': return Arrays.asList(new String[] { "g", "h", "i" });
            case '5': return Arrays.asList(new String[] { "j", "k", "l" });
            case '6': return Arrays.asList(new String[] { "m", "n", "o" });
            case '7': return Arrays.asList(new String[] { "p", "q", "r", "s" });
            case '8': return Arrays.asList(new String[] { "t", "u", "v" });
            case '9': return Arrays.asList(new String[] { "w", "x", "y", "z" });
        }
        return null;
    }

    public List<String> addToSoln( List<String> soln, List<String> map){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < soln.size(); i++){
            String k = soln.get(i);
            for(int j = 0; j < map.size(); j++){
                result.add( k + map.get(j));
            }
        }
        return result;
    }
    public List<String> letterCombinations(String s) {

        List<String> soln = new ArrayList<>();
        if(s.equals("")) return soln;
        soln.add("");
        for(int i=0; i<s.length(); i++){
            List<String> map = charNumMapping( s.charAt(i));
            soln = addToSoln( soln, map );
        }

        return soln;
    }

    public static void main(String[] args){
        LetterCombinations l = new LetterCombinations();
        l.letterCombinations("23");
    }
}
