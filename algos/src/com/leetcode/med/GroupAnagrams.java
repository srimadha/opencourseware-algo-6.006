package com.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sri on 4/9/2019.
 *
 *
 * https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.
 */
public class GroupAnagrams {
    public String getMeKey( String str){
        int count[] = new int[26];
        Arrays.fill( count, 0 );
        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            count[ c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for( int i=0; i<26; i++){
            sb.append('#');
            sb.append(count[i]);
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if( strs == null || strs.length == 0) return new ArrayList<>();
        HashMap< String, List> map = new HashMap<>();

        for( String str : strs ){
            String key = getMeKey( str );

            if( !map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add( str);

        }
        return new ArrayList(map.values());

    }
}
