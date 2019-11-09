package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeInorderTraversal {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal( root, inOrderList );
        return inOrderList;
    }

    private void inOrderTraversal( TreeNode root, ArrayList<Integer> inOrderList ){
        if( root != null ){
            inOrderTraversal(root.left, inOrderList);
            inOrderList.add(root.val);
            inOrderTraversal(root.right, inOrderList);
        }
    }
}