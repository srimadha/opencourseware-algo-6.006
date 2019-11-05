/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ZigZagLevelOrderBST {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> soln = new ArrayList<>();
        
        if( root == null ) return result;
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add( root );
        bfs.add( null );
        boolean left = false;
         ArrayList<Integer> rev = new ArrayList<>();
        while( !bfs.isEmpty() ){
            TreeNode parent = bfs.poll();
            if( parent == null ){
                if( left ){
                   
                    for(int i = soln.size() -1;i>=0; i--){
                        rev.add( soln.get(i));
                    }
                     result.add( rev );
                } else {
                    result.add( soln );
                }
                left = !left;
                rev = new ArrayList<>();
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
