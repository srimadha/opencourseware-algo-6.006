package com.leetcode.med;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sri on 1/7/2021.
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 Example:

 Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Output:
 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]

 https://leetcode.com/problems/group-shifted-strings

 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String key = generateKey(str);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }


        return new ArrayList<>(map.values());
    }

    private String generateKey(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < str.length(); i++) {
            int offset = str.charAt(i) - str.charAt(i - 1);

            if(offset < 0) {
                sb.append(offset + 26);
            } else {
                sb.append(offset);
            }
        }

        return sb.toString();
    }
}
