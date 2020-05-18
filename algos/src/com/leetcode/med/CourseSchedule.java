package com.leetcode.med;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseSchedule {



    /**
     * Beter than my stupid soln, dont know why did'nt do this
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] preCounts = new int[numCourses]; // preCounts[i]: pre course counts of course i.
        for (int[] pair : prerequisites) {
            int course = pair[0];
            preCounts[course]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (preCounts[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[count++] = course;
            for (int[] pair : prerequisites) {
                int c = pair[0], pre = pair[1];
                if (course == pre) {
                    preCounts[c]--;
                    if (preCounts[c] == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        return count == numCourses ? order : new int[0];
    }

    // Very bad run time
    /*class Node implements Comparable<Node>{
        int courseNumber;
        Set<Integer> preReqs;
        Node( int courseNumber ){
            this.courseNumber = courseNumber;
            preReqs = new HashSet<Integer>();
        }
        int getCourse() {
            return courseNumber;
        }
        @Override
        public int compareTo( Node node ){
            if( inDeg() == node.inDeg() ) return 0;
            else if( inDeg() < node.inDeg() ) return -1;
            else return 1;
        }
        void add( int preReq ) {
            preReqs.add( preReq );
        }
        int inDeg() {
            return preReqs.size();
        }
        Node getNode(){
            return this;
        }
        void remove(int preReq) {
            preReqs.remove(preReq);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Node> nodes = IntStream.rangeClosed(0, numCourses-1)
                .boxed().map( i -> new Node( i )).collect(Collectors.toList());

        Map<Integer, Node> mapNode = nodes.stream().collect(Collectors.toMap(Node::getCourse, Node::getNode));

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            mapNode.get(course).add(prereq);
        }

        Collection<Node> nodeList = mapNode.values();
        PriorityQueue<Node> pq = new PriorityQueue<>( nodeList );
        int result[] = new int[numCourses];
        int index = 0;
        while( pq.size() > 0 ){
            Node n = pq.poll();
            if( n.inDeg() != 0 )
                return new int[0];
            result[index] = n.courseNumber;

            List<Node> updatedList = pq.stream().map( node -> {
                node.remove(n.courseNumber);
                return node;
            }).collect(Collectors.toList());

            pq = new PriorityQueue<>( updatedList );
            index ++;
        }
        return result;
    }*/

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int prereq[][] = {
                {1,0},{2,0},{3,1},{3,2}
        };
       int res[] =  cs.findOrder(4, prereq);
        for (int i = 0; i < res.length ; i++) {
            System.out.print( res[i] + " ");
        }
    }
}
