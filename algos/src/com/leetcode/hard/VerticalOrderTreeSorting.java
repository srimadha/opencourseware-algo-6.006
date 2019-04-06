package com.leetcode.hard;

import java.util.*;

/**
 * Created by Sri on 4/5/2019.
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples 1:

 Input: [3,9,20,null,null,15,7]

 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7

 Output:

 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Examples 2:

 Input: [3,9,8,4,0,1,7]

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7

 Output:

 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Examples 3:

 Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2

 Output:

 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 */
public class VerticalOrderTreeSorting {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

// Ordering left-> right not maintained

    TreeMap<Integer, List<Integer>> vomap = new TreeMap<>();

    public void addNodeToMap( int value, Integer level ){
        if(vomap.containsKey(level)){
            List<Integer> l = vomap.get(level);
            l.add(value);
            vomap.put(level, l);
        } else{
            List<Integer> l = new ArrayList<>();
            l.add(value);
            vomap.put(level, l);
        }
    }

    public void voMap( TreeNode root, int level){
        if( root == null ) return;
        addNodeToMap( root.val, level );
        voMap( root.left, level -1);
        voMap( root.right, level +1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        addNodeToMap( root.val, 0 );
        voMap( root.left, -1);
        voMap( root.right, +1);

        List<List<Integer>> soln = new ArrayList<>();

        vomap.forEach((k, v) ->   soln.add(v) );

        return soln;
    }


    class LevelOrder{
        TreeNode node;
        int level;
        public LevelOrder(TreeNode node, int level){
            this.level = level;
            this.node = node;
        }
    }

  ///////////////////////////////////////////////////////////////////////
    /*
    Works like a charm!!
     */
    ///////////////////////////////////////////////////////////////////////

    public List<List<Integer>> verticalOrder2(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<LevelOrder> q = new LinkedList<>();

        q.add( new LevelOrder(root, 0));

        while( q.size() != 0){
            LevelOrder node = q.poll();
            if( node.node != null){
                addNodeToMap( node.node.val, node.level );
                q.add( new LevelOrder( node.node.left, node.level - 1));
                q.add( new LevelOrder( node.node.right, node.level + 1));
            }
        }

        List<List<Integer>> soln = new ArrayList<>();
        vomap.forEach((k, v) ->   soln.add(v) );
        return soln;
    }



}
