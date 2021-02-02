package com.leetcode.med;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sri on 1/29/2021.
 *
 * https://leetcode.com/problems/longest-string-chain/
 *
 * Given a list of words, each word consists of English lowercase letters.

 Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

 A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

 Return the longest possible length of a word chain with words chosen from the given list of words.



 Example 1:

 Input: words = ["a","b","ba","bca","bda","bdca"]
 Output: 4
 Explanation: One of the longest word chain is "a","ba","bda","bdca".
 Example 2:

 Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 Output: 5
 *
 *
 */
public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int res = 0;
        Arrays.sort( words, (String word1, String word2 ) -> {
            return word1.length() - word2.length();
        });

        for( String word : words ){
            int max = 0;
            for( int i = 0; i < word.length(); i++ ){
                String prev = word.substring( 0, i ) + word.substring( i + 1 );
                max = Math.max( max, dp.getOrDefault( prev, 0) + 1 );
                res = Math.max( res, max );
            }
            dp.put( word, max );
        }
        return res;
    }
}
