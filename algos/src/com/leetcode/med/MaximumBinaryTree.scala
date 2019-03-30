package com.leetcode.med

/**
  * https://leetcode.com/problems/maximum-binary-tree/
  *
  * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].
  * Created by Sri on 3/30/2019.
  */
class MaximumBinaryTree {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def findMaxIndex(nums: Array[Int], beginIndex: Int, endIndex: Int): Int = {
    var max = Integer.MIN_VALUE;
    var index = -1
    for (i <- beginIndex to endIndex) {
      if (max <= nums(i)) {
        max = nums(i)
        index = i
      }
    }
    return index;
  }

  def constructMaximumBinaryTreeHelper(nums: Array[Int], beginIndex: Int, endIndex: Int): TreeNode = {
    if (beginIndex > endIndex) return null
    val maxIndex = findMaxIndex(nums, beginIndex, endIndex)
    val root = TreeNode(nums(maxIndex));
    root.left = constructMaximumBinaryTreeHelper(nums, beginIndex, maxIndex - 1)
    root.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, endIndex)
    return root;
  }

  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    constructMaximumBinaryTreeHelper(nums, 0, nums.size - 1)
  }

}
