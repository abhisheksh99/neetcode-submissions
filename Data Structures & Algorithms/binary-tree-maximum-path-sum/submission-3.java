/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // compute max path sum from left/right children, ignore negatives
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // update global max if path through this node is better
        maxSum = Math.max(maxSum, left + right + node.val);

        // return max path sum extending from this node (to parent)
        return node.val + Math.max(left, right);
    }
}