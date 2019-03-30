package com.leetcode.med;

/**
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
