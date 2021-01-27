package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 1/23/2021.
 *
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 Example:

 Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 7

 Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 the point (1,2) is an ideal empty land to build a house, as the total
 travel distance of 3+3+1=7 is minimal. So return 7.
 Note:
 There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceBetweenAllBuildings {
    private boolean bfs( int[][] grid, int[][] distance, int[][] reach, int i, int j, int m, int n, int buildingCount) {
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer( new int[]{i, j});
        int level = 1;
        int count = 0;
        while( !q.isEmpty() ){
            int size = q.size();
            for( int qi = 0; qi < size; qi ++){
                int[] p = q.poll();
                List<List<Integer>> neighbours = getNeighbours( grid, p, m, n);

                for( List<Integer> neigh : neighbours ){

                    int ni = neigh.get(0);
                    int nj = neigh.get(1);

                    if( !visited[ni][nj] ){
                        if( grid[ni][nj] == 0 ){
                            visited[ni][nj] = true;
                            distance[ni][nj]+=level;
                            reach[ni][nj]++;
                            q.offer(new int[]{ ni, nj});
                        } else if( grid[ni][nj] == 1) {
                            count ++;
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
            level++;
        }
        return count == buildingCount;
    }

    private List<List<Integer>> getNeighbours( int[][] grid, int[] p, int m, int n){

        List<List<Integer>> neighbours = new ArrayList<>();
        int dirs[][] = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

        for( int[] dir : dirs ){
            int ni = dir[0]+p[0];
            int nj = dir[1]+p[1];

            if( ni >= 0 && nj >=0 && ni < m && nj < n ){
                neighbours.add( Arrays.asList(ni, nj));
            }

        }
        return neighbours;

    }

    public int shortestDistance(int[][] grid) {
        if( grid == null || grid.length == 0 ){
            return 0;
        }


        int m = grid.length;
        int n = grid[0].length;


        int reach[][] = new int[m][n];
        int distance[][] = new int[m][n];
        int buildingCount = 0;

        for( int i=0; i<m; i++){
            for( int j=0; j<n; j++){
                if( grid[i][j] == 1){
                    buildingCount++;
                }
            }
        }

        for( int i=0; i<m; i++){
            for( int j=0; j<n; j++){
                if( grid[i][j] == 1){
                    if( !bfs( grid, distance, reach, i, j, m, n, buildingCount ) ) {
                        return -1;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for( int j=0; j<n; j++){
                if( grid[i][j] == 0 && reach[i][j] == buildingCount ){
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
