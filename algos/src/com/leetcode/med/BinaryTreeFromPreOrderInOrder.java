package com.leetcode.med;

/**

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

**/

class BinaryTreeFromPreOrderInOrder {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int num) {
            this.val = num;
        }
    }
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildTree( preorder, inorder, 0, inorder.length-1);
    }
    
    public int search( int[] inorder, int start, int end, int value){
        for( int i=start; i<= end; i++){
            if( inorder[i] == value) return i;    
        }
        return -1;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd){
    
        if( inStart > inEnd ) return null;   
        
        TreeNode node = new TreeNode( preorder[ preIndex]);
        preIndex++;
        if(inStart == inEnd) return node;        
        int index = search( inorder, inStart, inEnd, node.val);
        
        node.left = buildTree( preorder, inorder, inStart, index-1);
        node.right = buildTree( preorder, inorder, index+1, inEnd);
        
        return node;
    }
   
 }
