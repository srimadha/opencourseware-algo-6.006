package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sri on 1/25/2021.
 *
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



 Example 1:


 Input: root = [1,3,null,null,2]
 Output: [3,1,null,null,2]
 Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 Example 2:


 Input: root = [3,1,4,null,null,2]
 Output: [2,1,4,null,null,3]
 Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


 Constraints:

 The number of nodes in the tree is in the range [2, 1000].
 -231 <= Node.val <= 231 - 1
 */
public class RecoverBinarySearchTree {
    public void inOrder(TreeNode root, List<Integer> nums){
        if( root != null ){
            inOrder(root.left, nums);
            nums.add( root.val);
            inOrder(root.right, nums);
        }
    }

    public int[] findSwapped( List<Integer> nums ){
        int x = -1;
        int y = -1;
        for(int i=0; i < nums.size() - 1; i++){
            if( nums.get(i+1) < nums.get(i) ){
                y = nums.get(i+1);
                if( x == -1 ){
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recoverTree( TreeNode root, int count, int[] swap ){
        if( root != null ){
            if( root.val == swap[0] || root.val == swap[1] ){
                root.val = root.val == swap[0] ? swap[1] : swap[0];
                count --;
                if( count == 0 )
                    return;
            }
            recoverTree( root.left, count, swap );
            recoverTree( root.right, count, swap );
        }
    }

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int swap[] = findSwapped(nums);
        recoverTree( root, 2, swap );
    }
}
