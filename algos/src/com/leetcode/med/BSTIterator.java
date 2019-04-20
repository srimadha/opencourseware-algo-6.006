package com.leetcode.med;

import java.util.Stack;

/**
 * Created by Sri on 4/19/2019.
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.



 Example:



 BSTIterator iterator = new BSTIterator(root);
 iterator.next();    // return 3
 iterator.next();    // return 7
 iterator.hasNext(); // return true
 iterator.next();    // return 9
 iterator.hasNext(); // return true
 iterator.next();    // return 15
 iterator.hasNext(); // return true
 iterator.next();    // return 20
 iterator.hasNext(); // return false


 Note:

 next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class BSTIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode current;
    Stack<TreeNode> treeStack;

    public BSTIterator(TreeNode root) {
        current = root;
        treeStack = new Stack<>();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (current != null) {
            treeStack.push(current);
            current = current.left;
        }
        TreeNode t = treeStack.pop();
        current = t.right;
        return t.val;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (current == null && treeStack.isEmpty()) return false;
        return true;
    }
}
