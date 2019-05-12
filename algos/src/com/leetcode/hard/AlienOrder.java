package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 5/11/2019.
 */
public class AlienOrder {
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
        StringBuilder sb = new StringBuilder();
        while( !q.isEmpty() ){
            Character ch = q.poll();

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

