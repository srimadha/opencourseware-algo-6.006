/**
https://leetcode.com/problems/binary-tree-level-order-traversal/


Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderTraversalTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> soln = new ArrayList<>();
        
        if( root == null ) return result;
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add( root );
        bfs.add( null );
        
        while( !bfs.isEmpty() ){
            TreeNode parent = bfs.poll();
            if( parent == null ){
                result.add( soln );
                soln = new ArrayList<>();
                if( bfs.size() > 0 )
                    bfs.add( null);
            } else {
                soln.add( parent.val );
                if(parent.left != null ) bfs.add(parent.left);
                if(parent.right != null ) bfs.add( parent.right );
            }
            
        }
        
        return result;
        
    }
}
