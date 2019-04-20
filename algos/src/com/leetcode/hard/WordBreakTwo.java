package com.leetcode.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sri on 4/19/2019.
 * <p>
 * https://leetcode.com/problems/word-break-ii/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
class WordBreakTwo {

    public List<String> wordBreak(String s, HashSet<String> set, List<String> soln) {

        if (s.equals("")) {
            return soln;
        }
        ArrayList<String> cummulative = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            String word = s.substring(0, i);

            if (set.contains(word)) {

                List<String> newSoln = soln.stream().map(str -> {
                    if (str == "") {
                        return word;
                    }
                    return str + " " + word;
                }).collect(Collectors.toList());
                List<String> tempRes = wordBreak(s.substring(i), set, newSoln);
                cummulative.addAll(tempRes);

            }


        }

        return cummulative;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSetDict = new HashSet<>(wordDict);
        List<String> soln = new ArrayList<>();
        soln.add("");
        return wordBreak(s, wordSetDict, soln);

    }

    public static void main(String[] args) {
        String str = "catsanddog";
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        WordBreakTwo wb = new WordBreakTwo();
        wb.wordBreak(str, list);
    }

    // Better solution
    public List<String> wordBreak1(String s, List<String> wordDict) {
        return DFS(s, new HashSet<String>(wordDict), new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

}
