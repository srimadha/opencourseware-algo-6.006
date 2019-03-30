package com.leetcode.med;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted linked list: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5


 * Created by Sri on 3/30/2019.
 */
public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode findRoot(ListNode head) {

        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;


        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode mid = this.findRoot(head);

        TreeNode node = new TreeNode(mid.val);

        if (head == mid) {
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;

    }
}
