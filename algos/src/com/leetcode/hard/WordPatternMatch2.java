package com.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sri on 1/25/2021.
 *
 * https://leetcode.com/problems/word-pattern-ii/
 *
 * Given a pattern and a string s, return true if s matches the pattern.

 A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.



 Example 1:

 Input: pattern = "abab", s = "redblueredblue"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "red"
 'b' -> "blue"
 Example 2:

 Input: pattern = "aaaa", s = "asdasdasdasd"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "asd"
 Example 3:

 Input: pattern = "abab", s = "asdasdasdasd"
 Output: true
 Explanation: One possible mapping is as follows:
 'a' -> "a"
 'b' -> "sdasd"
 Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
 Example 4:

 Input: pattern = "aabb", s = "xyzabcxzyabc"
 Output: false


 Constraints:

 0 <= pattern.length <= 20
 0 <= s.length <= 50
 pattern and s consist of only lower-case English letters.
 */
public class WordPatternMatch2 {
    public boolean wordPatternMatch(String pattern, String str) {
        if( pattern.length() > str.length())
            return false;
        return wordPatternMatch( pattern, str, new HashSet<>(), new HashMap<>());
    }

    public boolean wordPatternMatch(String pattern, String str,
                                    HashSet<String> visited, HashMap<Character, String> dict ){

        if(str.length() == 0 && pattern.length() == 0 ) return true;
        if(pattern.length() == 0) return false;
        boolean res;
        char currentChar = pattern.charAt(0);
        for(int i = 1; i <= str.length() - pattern.length() + 1; i++){
            String match = str.substring(0, i);
            if( visited.contains(match) ){
                if( dict.getOrDefault(currentChar, "").equals(match)){
                    res = wordPatternMatch( pattern.substring(1), str.substring(i), visited, dict);
                    if( res )
                        return res;
                }
            } else {
                if( !dict.containsKey(currentChar) ) {
                    visited.add(match);
                    dict.put( currentChar, match );
                    res = wordPatternMatch(pattern.substring(1), str.substring(i), visited, dict);
                    if(res)
                        return res;
                    dict.remove(currentChar);
                    visited.remove(match);
                }
            }
        }
        return false;
    }
}
