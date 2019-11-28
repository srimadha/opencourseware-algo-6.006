package com.leetcode.med;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public static void main(String[] args){
        System.out.println( new WordLadder().ladderLength("miss", "tusk", Arrays.asList("miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss")));
    }
    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> getNeighbours( String word, List<String> wordList ){
        if( !map.containsKey(word)){
            List<String> res = wordList.stream().filter( f -> oneletterdiff(word, f)).collect(Collectors.toList());
            map.put( word, res );
        }

        return map.get( word );
    }

    public boolean oneletterdiff( String a, String b){
        int diff = 0;
        for(int i=0; i<a.length(); i++){
            if( a.charAt(i) != b.charAt(i) ) {
                diff+=1;
                if( diff > 1){
                    return false;
                }
            }
        }
        if( diff == 0 ) return false;
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> bfs = new LinkedList<>();
        bfs.offer( beginWord );
        bfs.offer( null );
        int length = 1;
        boolean exhausted = false;
        HashSet<String> visited = new HashSet<>();
        while( !bfs.isEmpty() && !exhausted){
            String current = bfs.poll();
            if( current == null ){
                length += 1;
                if( bfs.peek() == null )
                    exhausted = true;
                bfs.offer(null);
            } else {
                exhausted = false;
                visited.add( current );
                List<String> neighbours = getNeighbours( current, wordList );
                List<String> unvisitedNeighbours = neighbours.stream().filter( n -> !visited.contains(n)).collect(Collectors.toList());

                if( unvisitedNeighbours.stream().filter( n -> n.equals(endWord)).count() ==  1 ) {
                    return length+1;
                }

                unvisitedNeighbours.stream().forEach(n -> {
                    visited.add(n);
                    bfs.offer(n);
                });
            }

        }
        return 0;
    }

    /**
     * Better soln
     */
    /*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.length() != endWord.length()) return 0;

        if(wordList == null) return 0;
        if(beginWord.equals(endWord)) return 2;

        Set<String> wordSet = new HashSet();
        Set<String> startSet = new HashSet();
        Set<String> endSet = new HashSet();

        for(String s : wordList){
            wordSet.add(s);
        }

        if(!wordSet.contains(endWord)) return 0;

        startSet.add(beginWord);
        endSet.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        return bfs(2,startSet,endSet,wordSet);


    }
    private int bfs(int steps, Set<String> beginSet, Set<String> endSet, Set<String> wordSet){

        HashSet<String> nextLevel = new HashSet<String>();

        for(String beginWord : beginSet){
            char[] charArray = beginWord.toCharArray();
            for(int pos = 0; pos < charArray.length; pos++){
                for(char chr = 'a'; chr <= 'z'; chr++){
                    charArray[pos] = chr;
                    String str = String.valueOf(charArray);
                    if(endSet.contains(str)) return steps;

                    if(wordSet.contains(str)){
                        nextLevel.add(str);
                        wordSet.remove(str);
                    }
                }
                charArray = beginWord.toCharArray();
            }
        }
        if(nextLevel.size() == 0) return 0;

        if(endSet.size() < nextLevel.size()){
            return bfs(steps + 1, endSet, nextLevel, wordSet);
        } else {
            return bfs(steps + 1, nextLevel, endSet, wordSet);
        }
    }
     */

}
