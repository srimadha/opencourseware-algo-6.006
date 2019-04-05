package com.leetcode.med;

/**
 * Created by Sri on 4/5/2019.
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class ValidateBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root, Integer lowerLimit, Integer upperLimit) {

        if (lowerLimit != null && root.val <= lowerLimit) return false;
        if (upperLimit != null && root.val >= upperLimit) return false;
        boolean left = root.left != null ? isValidBST(root.left, lowerLimit, root.val) : true;
        boolean right = root.right != null ? isValidBST(root.right, root.val, upperLimit) : true;

        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return root == null ? true : isValidBST(root, null, null);
    }

}
