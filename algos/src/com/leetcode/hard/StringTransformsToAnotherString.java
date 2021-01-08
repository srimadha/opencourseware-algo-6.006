package com.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Sri on 1/7/2021.
 * https://leetcode.com/problems/string-transforms-into-another-string/
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

 In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

 Return true if and only if you can transform str1 into str2.



 Example 1:

 Input: str1 = "aabcc", str2 = "ccdee"
 Output: true
 Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 Example 2:

 Input: str1 = "leetcode", str2 = "codeleet"
 Output: false
 Explanation: There is no way to transform str1 to str2.
 *
 */
public class StringTransformsToAnotherString {
    public boolean canConvert(String s1, String s2) {

        if (s1.equals(s2)) return true;

        Map<Character, Character> dp = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    }
}
