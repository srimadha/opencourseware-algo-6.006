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
    static boolean isv(char c)
    {
        return (c=='a' || c=='A' || c=='e' || c=='E' || c=='i'|| c=='I'|| c=='o'|| c=='O'|| c=='u'||c=='U');
    }
    public String reverseVowels(String s) {

        int i=0;
        int j=s.length()-1;
        char ch[]=s.toCharArray();
        while(i<j)
        {
            if(!isv(ch[i]))
            {
                i++;
                continue;
            }
            if(!isv(ch[j]))
            {
                j--;
                continue;
            }
            char t=ch[i];
            ch[i]=ch[j];
            ch[j]=t;
            i++;
            j--;
        }
        String st=String.copyValueOf(ch);
        return st;
    }
}
