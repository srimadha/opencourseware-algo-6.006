package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 1/17/2021.
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

 A critical connection is a connection that, if removed, will make some server unable to reach some other server.

 Return all critical connections in the network in any order.



 Example 1:



 Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 Output: [[1,3]]
 Explanation: [[3,1]] is also accepted.


 Constraints:

 1 <= n <= 10^5
 n-1 <= connections.length <= 10^5
 connections[i][0] != connections[i][1]
 There are no repeated connections.

 https://leetcode.com/problems/critical-connections-in-a-network/

 https://www.youtube.com/watch?v=RYaakWv5m6o

 */
public class CriticalConnectionsInNetwork {

    private int time = 0; // current time of discovery

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); // node -> neighbors

        for (List<Integer> conn : connections) {
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            graph.putIfAbsent(n1, new ArrayList<>());
            graph.putIfAbsent(n2, new ArrayList<>());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int[] disc = new int[n]; // discovery time of each node
        int[] low = new int[n]; // earliest discovered node reachable from this node in DFS
        boolean[] visited = new boolean[n]; // whether this node has been visited in DFS
        List<List<Integer>> out = new ArrayList<>();

        dfs(0, -1, disc, low, visited, graph, out); // arbitrarily pick a node to start DFS

        return out;
    }

    // root = current node under consideration
    // parent = parent of current node
    private void dfs(int root, int parent, int[] disc, int[] low, boolean[] visited, Map<Integer, List<Integer>> graph, List<List<Integer>> out) {
        visited[root] = true;
        disc[root] = time++;
        low[root] = disc[root]; // we don't have to initialize low[] to inf because of this line

        List<Integer> neighbors = graph.get(root);
        if (neighbors == null) {
            return;
        }

        for (Integer nei : neighbors) {
            if (nei == parent) {
                continue;
            }

            if (!visited[nei]) {
                dfs(nei, root, disc, low, visited, graph, out);
                low[root] = Math.min(low[root], low[nei]);
                if (disc[root] < low[nei]) {
                    out.add(Arrays.asList(root, nei));
                }
            } else {
                low[root] = Math.min(low[root], disc[nei]);
            }
        }
    }


}
