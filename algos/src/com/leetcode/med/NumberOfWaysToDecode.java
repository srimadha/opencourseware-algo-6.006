package com.leetcode.med;

import java.util.HashMap;

class NumberOfWaysToDecode {
    static HashMap<String, Integer> map = new HashMap<>();
    public static int numDecodings(String s) {
        if( s == null || s.length() == 0 ){
            return 1;
        } else if( s.charAt(0) == '0') {
            return 0;
        } else {
            if( map.containsKey(s) ) return map.get(s);
            int firstDigit = Integer.parseInt(s.charAt(0)+"");
            int count = 0;
            if(firstDigit != 0 ){
                count += numDecodings( s.substring(1));
            }
            if( s.length() >= 2){
                int twoDigit = Integer.parseInt(s.substring(0,2));
                if(twoDigit <=26 ){
                    if( s.length() > 2)
                        count += numDecodings( s.substring(2));
                    else
                        count += 1;
                }
            }
            map.put(s, count);
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
    }
}