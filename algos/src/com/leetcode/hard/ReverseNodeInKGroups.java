package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sri on 4/9/2019.
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseNodeInKGroups {


    public static void main(String[] args) {
        ReverseNodeInKGroups k = new ReverseNodeInKGroups();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        k.reverseKGroup(node, 2);

    }

    public List<ListNode> split(ListNode curr, int k) {

        List<ListNode> groupedNodes = new ArrayList<>();

        ListNode firstNode = curr;

        while (curr != null) {
            for (int i = 1; i < k; i++) {
                if (curr == null) {
                    groupedNodes.add(firstNode);
                    return groupedNodes;
                }
                curr = curr.next;
            }
            if (curr == null) {
                groupedNodes.add(firstNode);
                return groupedNodes;
            } else {
                ListNode temp = curr.next;
                curr.next = null;
                groupedNodes.add(firstNode);
                firstNode = temp;
                curr = temp;
            }
        }

        return groupedNodes;

    }

    public int sizeOfListNode(ListNode head) {
        int count = 0;
        ListNode iter = head;
        while (iter != null) {
            iter = iter.next;
            count++;
        }
        return count;
    }

    public ListNode reverse(ListNode head, int k) {
        if (sizeOfListNode(head) < k) return head;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            if (next == null)
                return curr;
            prev = curr;
            curr = next;

        }

        return head;
    }

    public ListNode reverse(List<ListNode> grouped, int k) {
        List<ListNode> reverseNode = grouped.stream().map(x -> reverse(x, k)).collect(Collectors.toList());

        ListNode result = reverseNode.get(0);
        ListNode iter = reverseNode.get(0);
        for (int i = 1; i < reverseNode.size(); i++) {
            while (iter.next != null) iter = iter.next;
            iter.next = reverseNode.get(i);

        }
        return result;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return head;
        List<ListNode> grouped = split(head, k);
        ListNode reversedNode = reverse(grouped, k);

        return reversedNode;

    }
}
