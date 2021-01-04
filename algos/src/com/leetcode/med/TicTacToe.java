package com.leetcode.med;

/**
 * Created by Sri on 1/4/2021.
 */

/*

https://leetcode.com/problems/design-tic-tac-toe/


Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
Follow up:
Could you do better than O(n2) per move() operation?
 */
class TicTacToe {

    int matrix[][];
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        matrix = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        matrix[row][col] = player;
        return winCondition( row, col, player );
    }

    private int winCondition( int row, int col, int player ){

        if( checkRow( row, player )){
            return player;
        }

        if( checkCol( col, player )){
            return player;
        }
        if( checkDiagnol( player )) {
            return player;
        }
        return 0;
    }

    private boolean  checkRow( int row, int player ){
        for( int j = 0; j < n; j++ ){
            if( matrix[row][j] != player )
                return false;
        }
        return true;
    }

    private boolean  checkCol( int col, int player ){
        for( int i = 0; i < n; i++ ){
            if( matrix[i][col] != player )
                return false;
        }
        return true;
    }

    private boolean checkDiagnol( int player ){
        if( checkDiagnol1( player ))
            return true;
        if( checkDiagnol2( player ))
            return true;

        return false;
    }
    private boolean  checkDiagnol1(  int player ){
        for( int i = 0; i < n; i++ ){
            if( matrix[i][i] != player )
                return false;
        }
        return true;
    }
    private boolean  checkDiagnol2( int player ){
        for( int i = 0; i < n; i++ ){
            if( matrix[i][n-i-1] != player )
                return false;
        }
        return true;
    }
}

