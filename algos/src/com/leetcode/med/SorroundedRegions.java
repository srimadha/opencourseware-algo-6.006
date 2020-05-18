package com.leetcode.med;

/**
 *
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SorroundedRegions {
    public void dfs( char[][] board, boolean[][] visited, int i, int j, int row, int col){
        if( visited[i][j] == true )
            return;

        visited[i][j] = true;
        int xoff[] = {0, 0, 1, -1};
        int yoff[] = {1, -1, 0, 0};

        for( int k=0; k<4; k++){
            int x = i + xoff[k];
            int y = j + yoff[k];

            if( x >= 0 && y >= 0 && x < row && y < col && ( visited[x][y] == false && board[x][y] == 'O')){
                dfs(board, visited, x, y, row, col);
            }

        }

    }

    public void solve(char[][] board) {
        int row = board.length;
        if (row < 1) return;
        int col = board[0].length;
        if (col < 1) return;
        boolean visited[][] = new boolean[row][col];

        for( int i=0; i<row; i++){
            if( visited[i][0] == false && board[i][0] == 'O'){
                dfs( board, visited, i, 0, row, col);
            }

            if( visited[i][col - 1] == false && board[i][col -1] == 'O'){
                dfs( board, visited, i, col - 1, row, col);
            }
        }

        for( int j=0; j<col; j++){
            if( visited[0][j] == false && board[0][j] == 'O'){
                dfs( board, visited, 0, j, row, col);
            }

            if( visited[row-1][j] == false && board[row-1][j] == 'O'){
                dfs( board, visited, row - 1, j, row, col);
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col ;j++){
                if(visited[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
