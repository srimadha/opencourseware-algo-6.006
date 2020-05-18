package com.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

public class SerializeDeserializeTree {
    /**
     * Definition for a binary tree node. */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

     class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder res = new StringBuilder();
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode current = queue.removeFirst();
                if (current==null)res.append("null");
                else {
                    res.append(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
                if (!queue.isEmpty())res.append(",");
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] splited = data.split(",");
            Deque<TreeNode>queue= new LinkedList<>();
            TreeNode root = splited[0].equals("null")?null:new TreeNode(Integer.valueOf(splited[0]));
            queue.add(root);
            int leftChild=1;
            while(!queue.isEmpty())
            {
                TreeNode current = queue.removeFirst();
                if (current!=null){
                    TreeNode left = splited[leftChild].equals("null")?null:new TreeNode(Integer.valueOf(splited[leftChild]));
                    current.left=left;
                    TreeNode right = splited[leftChild+1].equals("null")?null:new TreeNode(Integer.valueOf(splited[leftChild+1]));
                    current.right=right;
                    queue.add(left);
                    queue.add(right);
                    leftChild+=2;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
