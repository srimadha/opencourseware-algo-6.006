package com.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sri on 4/30/2019.
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Input: [5,2,6,1]
 Output: [2,1,1,0]
 Explanation:
 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 */
public class CountOfSmallerNumbersAfterSelf {



        class Node{
            int val;
            Node left,  right;
            int smallerOrEq;

            public Node( int x ){
                this.val = x;
                this.smallerOrEq = 1;
            }
        }

        public int searchEqOrLess( Node root, int val ){
            if( root == null ){
                return 0;
            } else if( root.val == val){
                return root.smallerOrEq;
            }else if(root.val < val){
                return root.smallerOrEq + searchEqOrLess(root.right, val);
            }else{
                return searchEqOrLess(root.left, val);
            }
        }

        public Node insert( Node root, int val){
            if( root == null ){
                return new Node( val );
            } else if( root.val < val){
                root.right = insert(root.right, val);
            } else if ( root.val > val ){
                root.left = insert(root.left, val);
                root.smallerOrEq++;
            } else {
                root.smallerOrEq++;
            }
            return root;
        }

        public List<Integer> countSmaller(int[] nums) {
            LinkedList<Integer> ans = new LinkedList();
            Node root = null;
            for(int i = nums.length - 1; i>=0; i--){
                ans.addFirst( searchEqOrLess( root, nums[i] - 1));
                root = insert( root, nums[i]);
            }
            return ans;
        }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf cs = new CountOfSmallerNumbersAfterSelf();
        cs.countSmaller( new int[]{5,2,6,1});
    }
}
