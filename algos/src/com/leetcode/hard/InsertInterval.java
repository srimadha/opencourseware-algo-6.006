package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null || newInterval.length == 0) return null;
        if (intervals.length == 0) return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        boolean alreadyDone = false;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                if (!alreadyDone) {
                    result.add(newInterval);
                    alreadyDone = true;
                }
                result.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if (!alreadyDone) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        //int intervals[][] = {{1, 3}, {6, 9}};
        //int interval[] = {2, 5};

        //int intervals[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        //int interval[] = {4, 8};
        int intervals[][] = {{3,5},{12,15}};
        int interval[] = {6, 6};
        int results[][] = i.insert(intervals, interval);
        for(int result[] : results){
            System.out.println( result[0] +"-" +result[1]);
        }
    }
}
