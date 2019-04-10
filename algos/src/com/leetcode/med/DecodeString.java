package com.leetcode.med;

/**
 * Created by Sri on 4/9/2019.
 *
 * https://leetcode.com/problems/decode-string/

 Given an encoded string, return it's decoded string.
 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for( int i = pos; i < s.length(); i ++){
            char ch = s.charAt(i);

            if( Character.isDigit(ch)){
                num += ch;
            } else if( ch == '['){
                pos = i + 1;
                String next = decodeString(s);
                for(int j=Integer.valueOf(num); j>0; j--) sb.append(next);
                num = "";
                i=pos;
            } else if( ch == ']'){
                pos = i;
                return sb.toString();
            } else {
                sb.append(ch);
            }


        }
        return sb.toString();

    }
}
