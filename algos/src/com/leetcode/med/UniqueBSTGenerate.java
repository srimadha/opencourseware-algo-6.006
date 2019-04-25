package com.leetcode.med;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sri on 4/24/2019.
 * <p>
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBSTGenerate {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getRightNodes(List<Integer> nodes, int i) {
        if (i == nodes.size() - 1) {
            return new ArrayList<>();
        }
        return nodes.subList(i + 1, nodes.size());
    }

    public List<TreeNode> generateTrees(List<Integer> nodes) {
        List<TreeNode> results = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++) {

            List<TreeNode> leftNodes = generateTrees(nodes.subList(0, i));
            List<TreeNode> rightNodes = generateTrees(getRightNodes(nodes, i));

            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    TreeNode tNode = new TreeNode(nodes.get(i));
                    tNode.left = l;
                    tNode.right = r;
                    results.add(tNode);
                }
            }
        }

        if (results.size() == 0) {
            results.add(null);
        }

        return results;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) nodes.add(i);

        return generateTrees(nodes);
    }
}
