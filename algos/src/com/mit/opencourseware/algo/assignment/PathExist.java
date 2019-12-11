package com.mit.opencourseware.algo.assignment;

import java.util.*;

/**
 *  Input: An unweighted directed graph. Write code to find out if there is a path between two nodes.
 */
public class PathExist {
    class Node {
        int node;
        HashSet<Integer> adjList;
        public Node(int node){
            this.node = node;
            this.adjList = new HashSet<>();
        }
        public void addAdjNode( int node ){
            adjList.add( node );
        }

        public void addAdjNode( List<Integer> nodes ){
            adjList.addAll( nodes );
        }
    }

    public boolean isThereAPath( int source, int dest , HashMap<Integer, Node> nodeMap){

        Queue<Node> q = new LinkedList<>();
        q.offer( nodeMap.get(source) );
        HashSet<Integer> visited = new HashSet<>();
        while( !q.isEmpty() ){
            Node node = q.poll();
            visited.add( node.node );
            HashSet<Integer> neighbours = node.adjList;
            if( neighbours.contains( dest )){
                return true;
            }
            Iterator<Integer> it = neighbours.iterator();
            while( it.hasNext() ){
                Integer neighbour = it.next();
                if( !visited.contains(neighbour)){
                    q.offer( nodeMap.get(neighbour) );
                }
            }
        }
        return false;
    }

}
