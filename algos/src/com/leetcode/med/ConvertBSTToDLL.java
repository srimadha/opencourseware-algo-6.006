package com.leetcode.med;

/**
 * Created by Sri on 1/23/2021.
 *
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

 You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

 We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.



 Example 1:



 Input: root = [4,2,5,1,3]


 Output: [1,2,3,4,5]

 Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

 Example 2:

 Input: root = [2,1,3]
 Output: [1,2,3]
 Example 3:

 Input: root = []
 Output: []
 Explanation: Input is an empty tree. Output is also an empty Linked List.
 Example 4:

 Input: root = [1]
 Output: [1]


 Constraints:

 -1000 <= Node.val <= 1000
 Node.left.val < Node.val < Node.right.val
 All values of Node.val are unique.
 0 <= Number of Nodes <= 2000
 */
public class ConvertBSTToDLL {
    class Node {
        int val;
        Node left;
        Node right;
    }
    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;

        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);

        root.left = root.right = root;

        return concatenate(concatenate(left, root), right);

    }

    public Node concatenate(Node leftList,Node rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        Node leftLast = leftList.left;

        // Store the last Node of right List
        Node rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

}
