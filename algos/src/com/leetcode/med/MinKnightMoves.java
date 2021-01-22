package com.leetcode.med;

import java.util.*;

/**
 * Created by Sri on 1/15/2021.
 */
public class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Map<String, Integer> posToCounts = new HashMap<>();

        return dfs(x, y, posToCounts);
    }

    private int dfs(int x, int y, Map<String, Integer> posToCounts) {
        String pos = x + "," + y;
        if (posToCounts.containsKey(pos)) {
            return posToCounts.get(pos);
        }

        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }

        int count = Math.min(
                dfs(Math.abs(x - 1), Math.abs(y - 2), posToCounts),
                dfs(Math.abs(x - 2), Math.abs(y - 1), posToCounts)
        ) + 1;

        posToCounts.put(pos, count);
        return count;
    }

    public int minKnightMoves1(int x, int y) {
        int dirs[][] = new int[][]{{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-2,-1},{-1,-2} };
        x = Math.abs( x );
        y = Math.abs( y );
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add( new int[]{0,0});
        visited.add( "0,0");

        int result = 0;

        while( !q.isEmpty() ){

            int size = q.size();

            for( int i=0; i<size; i++ ){

                int[] move = q.remove();
                if( move[0] == x && move[1] == y ){
                    return result;
                }

                for( int[] dir : dirs ){
                    int newx = dir[0] + move[0];
                    int newy = dir[1] + move[1];

                    String moveStr = newx+","+newy;
                    if( !visited.contains(moveStr) && newx >= -1 && newy >= -1){
                        visited.add(moveStr);
                        q.add( new int[]{newx, newy});
                    }


                }


            }
            result++;

        }

        return -1;
    }
}
