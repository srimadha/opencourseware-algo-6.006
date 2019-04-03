package com.leetcode.med;

/**
 * Created by Sri on 4/2/2019.
 *
 * https://leetcode.com/problems/number-of-islands/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 */
public class NumberOfIslands {
    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void markContigiousLand(char[][] grid, int x, int y) {
        grid[x][y] = 'V';
        if (checkBoundry(grid, x + 1, y) && grid[x + 1][y] == '1') {
            markContigiousLand(grid, x + 1, y);
        }
        if (checkBoundry(grid, x, y + 1) && grid[x][y + 1] == '1') {
            markContigiousLand(grid, x, y + 1);
        }
        if (checkBoundry(grid, x - 1, y) && grid[x - 1][y] == '1') {
            markContigiousLand(grid, x - 1, y);
        }
        if (checkBoundry(grid, x, y - 1) && grid[x][y - 1] == '1') {
            markContigiousLand(grid, x, y - 1);
        }

    }

    public boolean checkBoundry(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;

        return x < row && y < col && x >= 0 && y >= 0;

    }

    public Pos findPos(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    return new Pos(i, j);
                }
            }
        }
        return null;
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        System.out.println(row + "," + col);
        int count = 0;
        Pos pos = findPos(grid);
        while (pos != null) {
            markContigiousLand(grid, pos.x, pos.y);
            count += 1;
            pos = findPos(grid);
        }
        return count;
    }
}
