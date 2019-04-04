package com.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Sri on 4/3/2019.
 *
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 *
 */
public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override()
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (pq.size() > 0) {
            ListNode nextNode = pq.poll();
            if (nextNode.next != null)
                pq.offer(nextNode.next);

            curr.next = nextNode;
            curr = nextNode;
        }
        return head.next;
    }
}
