package com.leetcode.med;

/**
 * Created by Sri on 4/3/2019.
 * https://leetcode.com/problems/meeting-rooms-ii/
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRooms {

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private int getMinStart(Interval[] intervals) {
        int min = Integer.MAX_VALUE;
        for (Interval interval : intervals) {
            if (min > interval.start) {
                min = interval.start;
            }
        }
        return min;
    }

    private int getMaxStart(Interval[] intervals) {
        int max = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (max < interval.start) {
                max = interval.start;
            }
        }
        return max;
    }

    private void addOverlap(int[] overlaps, int index, int inc) {
        if (index >= overlaps.length) return;
        overlaps[index] += inc;
    }

    private int[] getOverLaps(Interval[] intervals, int firstMeetingStart, int lastMeetingStart) {
        int[] overlaps = new int[lastMeetingStart - firstMeetingStart + 1];

        for (Interval interval : intervals) {
            addOverlap(overlaps, interval.start - firstMeetingStart, 1);
            addOverlap(overlaps, interval.end - firstMeetingStart, -1);
        }
        return overlaps;
    }

    private int getMinRoomsRequired(int[] overlaps) {
        int minRoomsRequired = Integer.MIN_VALUE;
        int currMax = 0;
        for (int overlap : overlaps) {
            currMax += overlap;
            if (currMax > minRoomsRequired) {
                minRoomsRequired = currMax;
            }
        }
        return minRoomsRequired;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        int firstMeetingStart = getMinStart(intervals);
        int lastMeetingStart = getMaxStart(intervals);
        int meetingOverlap[] = getOverLaps(intervals, firstMeetingStart, lastMeetingStart);
        return getMinRoomsRequired(meetingOverlap);
    }
}
