package com.leetcode.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/word-search-ii/
 *
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class WordSearchTwo {
    public List<String> findWords(char[][] board, String[] words) {
        return Arrays.asList( words ).stream().filter(word -> {
            return exist(board, word);
        }).collect(Collectors.toList());
    }

    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if( board[i][j] == word.charAt(0) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search( char[][]board, String word, int i, int j, int index){

        if( index == word.length() ){
            return true;
        }

        if( i < 0 || j < 0 ||
                i >= board.length || j >= board[i].length ||
                board[i][j] != word.charAt(index) || visited[i][j] ){
            return false;
        }

        visited[i][j] = true;

        if( search(board, word, i+1, j, index+1) ||
                search(board, word, i-1, j, index+1) ||
                search(board, word, i, j+1, index+1) ||
                search(board, word, i, j-1, index+1) ){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
