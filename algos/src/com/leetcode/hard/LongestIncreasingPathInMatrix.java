package com.leetcode.hard;

import java.util.HashMap;

public class LongestIncreasingPathInMatrix {
    public int maximizePath(int[][] matrix, int x, int y, int cache[][], int m, int n) {

        if (cache[x][y] != 0) return cache[x][y];


        int left = Integer.MIN_VALUE;

        if (x - 1 >= 0 && matrix[x - 1][y] > matrix[x][y]) {
            left = maximizePath(matrix, x - 1, y, cache, m, n);
        }


        int right = Integer.MIN_VALUE;
        if (x + 1 < m && matrix[x + 1][y] > matrix[x][y]) {
            right = maximizePath(matrix, x + 1, y, cache, m, n);
        }


        int top = Integer.MIN_VALUE;
        if (y - 1 >= 0 && matrix[x][y - 1] > matrix[x][y]) {
            top = maximizePath(matrix, x, y - 1, cache, m, n);
        }


        int bottom = Integer.MIN_VALUE;

        if (y + 1 < n && matrix[x][y + 1] > matrix[x][y]) {
            bottom = maximizePath(matrix, x, y + 1, cache, m, n);
        }
        int hmax = Math.max(left, right);
        int vmax = Math.max(top, bottom);
        if (hmax == vmax && hmax == Integer.MIN_VALUE) {
            cache[x][y] = 1;
        } else {
            cache[x][y] = 1 + Math.max(hmax, vmax);
        }

        return cache[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int cache[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, maximizePath(matrix, i, j, cache, m, n));
            }
        }
        return max;
    }
}
