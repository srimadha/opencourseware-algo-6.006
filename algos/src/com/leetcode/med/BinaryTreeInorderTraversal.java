package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** https://leetcode.com/problems/binary-tree-inorder-traversal/ **/
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
    public void inorderTraversalIter(TreeNode root, List<Integer> result){
        Stack<TreeNode> inOrderStack = new Stack<>();

        while(true){
            while( root != null){
                inOrderStack.push(root);
                root = root.left;
            }
            if( inOrderStack.isEmpty()){
                return;
            }
            TreeNode printNode = inOrderStack.pop();
            result.add(printNode.val);
            if( printNode.right != null)
                root = printNode.right;
        }

    }
}