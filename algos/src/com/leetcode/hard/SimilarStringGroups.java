package com.leetcode.hard;

/**
 * Created by Sri on 1/22/2021.
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

 For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

 Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

 We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?



 Example 1:

 Input: strs = ["tars","rats","arts","star"]
 Output: 2
 Example 2:

 Input: strs = ["omv","ovm"]
 Output: 1


 Constraints:

 1 <= strs.length <= 100
 1 <= strs[i].length <= 1000
 sum(strs[i].length) <= 2 * 104
 strs[i] consists of lowercase letters only.
 All words in strs have the same length and are anagrams of each other.

 https://leetcode.com/problems/similar-string-groups/
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {

        if( strs.length < 2 ) return strs.length;

        int simGroups = 0;

        for( int i = 0; i < strs.length; i++ ){
            if( strs[i] == null ) continue;
            String key = strs[i];
            strs[i] = null;
            dfs( key, strs );
            simGroups++;

        }

        return simGroups;
    }

    private void dfs( String key, String strs[] ){
        for( int i = 0; i < strs.length; i++ ){
            if( strs[i] == null ) continue;
            if(isSimilar(key,strs[i])){// both string str and arr[i] belong in same group
                String s = strs[i];
                strs[i] = null;
                dfs(s, strs);
            }
        }
    }

    private boolean isSimilar( String s, String t ){
        int res = 0, i = 0;
        if( s.equals( t ))
            return true;
        while(res <= 2 && i < s.length()){
            if(s.charAt(i) != t.charAt(i)) res++;
            i++;
        }
        return res == 2;
    }
}
