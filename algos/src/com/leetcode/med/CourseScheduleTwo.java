package com.leetcode.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseScheduleTwo {
    class Node {
        int s;
        ArrayList<Integer> neighbours;
        int inc;

        public Node( int s ){
            this.s = s;
            this.neighbours = new ArrayList<>();
            this.inc = 0;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for(int i = 0; i<numCourses; i++){
            nodes[i] = new Node(i);
        }

        for(int prereq[] : prerequisites) {
            nodes[prereq[0]].inc ++;
            nodes[prereq[1]].neighbours.add(prereq[0]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if( n1.inc < n2.inc){
                    return -1;
                } else if( n1.inc == n2.inc ){
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        pq.addAll(Arrays.asList(nodes));

        while( !pq.isEmpty() ){
            Node n = pq.poll();
            if( n.inc != 0 ) {
                return false;
            }
            for(int x: n.neighbours){
                Node temp = nodes[x];
                pq.remove(temp);
                temp.inc--;
                pq.add(temp);
            }
        }
        return true;
    }
}
