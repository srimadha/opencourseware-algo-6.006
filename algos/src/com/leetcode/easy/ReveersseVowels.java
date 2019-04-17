package com.leetcode.easy;

import java.util.HashSet;

/**
 * Created by Sri on 4/14/2019.
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:

 Input: "hello"
 Output: "holle"
 Example 2:

 Input: "leetcode"
 Output: "leotcede"
 Note:
 The vowels does not include the letter "y".
 */
public class ReveersseVowels {
    public String reverseVowels(String s) {
        String res = "";
        int j = s.length() - 1;
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
        for(char ch : s.toCharArray()){
            if(vowels.contains(ch)){
                char c = s.charAt(j);
                while(!vowels.contains(c) && j > 0){
                    j --;
                    c = s.charAt(j);
                }
                j--;
                res = res + c;
            }else{
                res = res + ch;
            }
        }

        return res;
    }
}
