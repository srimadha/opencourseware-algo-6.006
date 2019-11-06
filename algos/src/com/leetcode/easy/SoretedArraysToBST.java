/**
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
**/

public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArraysToBST( nums, 0, nums.length - 1);
    }
    private TreeNode sortedArraysToBST( int[] nums, int low, int high){
        if( low > high ) return null;
        int mid = (low + high)/2;
        TreeNode node = new TreeNode( nums[mid] );
        if( low == high ) { return node;}
        node.left = sortedArraysToBST(nums, low, mid-1);
        node.right = sortedArraysToBST( nums, mid+1, high);
        return node;
        
    }
