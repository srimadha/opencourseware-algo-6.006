package com.leetcode.med;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
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
