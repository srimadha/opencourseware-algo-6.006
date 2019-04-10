package com.leetcode.hard;

/**
 * Created by Sri on 4/9/2019.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
  
 Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7

 Output: 42
 */

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum( TreeNode root){
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if( root == null ){
            return 0;
        }
        int left = Math.max(0, maxGain(root.left) );
        int right = Math.max(0, maxGain(root.right) );
        int price_newpath = root.val + left + right;

        max = Math.max( max, price_newpath);

        return Math.max(left, right) + root.val;
    }
}
