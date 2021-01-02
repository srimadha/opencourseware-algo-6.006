package com.leetcode.hard;

/**
 * Created by Sri on 1/2/2021.
 */
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int sindex = 0, tindex = 0, slen = s.length, tlen = t.length, start = -1, len = slen;


        while( sindex < slen ){

            if( s[sindex] == t[tindex] ){

                if( ++tindex == tlen){
                    int end = sindex + 1;

                    while( --tindex >= 0 ){
                        while( s[sindex--] != t[tindex]);
                    }
                    sindex++;
                    tindex++;
                    if( end - sindex < len ){
                        len = end - sindex;
                        start = sindex;
                    }


                }

            }
            sindex++;
        }


        return start == -1? "" : S.substring(start, start + len);
    }
}
