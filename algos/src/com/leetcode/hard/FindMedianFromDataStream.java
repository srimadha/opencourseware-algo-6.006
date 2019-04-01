package com.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Sri on 3/31/2019.
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 For example,
 [2,3,4], the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.


 Example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2


 Follow up:

 If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                if(n1 == n2) return 0;
                else if(n1 < n2) return -1;
                else return 1;
            }
        }
        );
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                if(n1 == n2) return 0;
                else if(n1 < n2) return 1;
                else return -1;
            }
        }
        );
    }

    public void addNum(int num) {
        if(minQueue.size() == maxQueue.size()){
            if( minQueue.size() > 0 && minQueue.peek() <= num  ){
                minQueue.add( num );
            } else if(minQueue.size() > 0 && minQueue.peek() > num){
                maxQueue.add(num);
                int tNum = maxQueue.poll();
                minQueue.add( tNum );
            } else {
                minQueue.add( num );
            }

        } else {
            if( minQueue.peek() >= num ) {
                maxQueue.add(num);
            } else {
                minQueue.add( num );
                int tNum = minQueue.poll();
                maxQueue.add( tNum );
            }
        }
    }

    public double findMedian() {
        if(minQueue.size() == maxQueue.size()){
            return ( minQueue.peek() + maxQueue.peek() ) / 2.0;
        } else {
            return minQueue.peek();
        }
    }
}
