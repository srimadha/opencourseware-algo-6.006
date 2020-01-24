package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 5/11/2019.
 *
 * https://leetcode.com/problems/alien-dictionary/
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienOrder {
    public static void main(String[] args) {
        AlienOrder a =new AlienOrder();
        a.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
    }
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap();
        int inDegree[] = new int[26];
        buildGraph(words, graph, inDegree);
        String res = topologicalOrder( graph, inDegree);
        return res.length() == graph.size() ? res : "";
    }
    public String topologicalOrder(Map<Character, Set<Character>> graph , int inDegree[]){
        Queue<Character> q = new LinkedList<>();
        for( Character ch : graph.keySet()){
            if(inDegree[ch - 'a'] == 0){
                q.offer(ch);
            }
        }
        //[0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0]
        //[0,0,0,0,1,1,
        StringBuilder sb = new StringBuilder();
        while( !q.isEmpty() ){
            Character ch = q.poll(  );

            Set<Character> neighbours = graph.get(ch);
            for( Character n : neighbours ){
                inDegree[n - 'a']--;
                if(inDegree[n - 'a'] == 0){
                    q.offer(n);
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    public void buildGraph( String words[],  Map<Character, Set<Character>> graph , int inDegree[] ){
        for(String word : words){
            for(Character ch : word.toCharArray()){
                graph.put(ch, new HashSet<Character>());
            }
        }
        for(int i=1; i<words.length ;i++){
            String first = words[i-1];
            String second = words[i];
            int len = Math.min( first.length(), second.length() );
            for(int j=0;j<len;j++){
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}

