package com.leetcode.easy

/**
  * https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
  * 101. Symmetric Tree
  * Created by Sri on 3/29/2019.
  */
object SymmetricTree {

  class TreeNode(var _value: Int) {
       var value: Int = _value
       var left: TreeNode = null
       var right: TreeNode = null
  }

  def isEqual( left: TreeNode, right: TreeNode ) : Boolean = {
    if ( left == null && right == null ) {
      return true
    } else if( left == null || right == null || left.value != right.value ) {
      return false
    } else {
      isEqual( left.left, right.right ) && isEqual( left.right, right.left )
    }
  }
  def isSymmetric(root: TreeNode): Boolean = {
    if( root == null ) return true
    isEqual( root.left, root.right )
  }

}
