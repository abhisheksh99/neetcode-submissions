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

public class Solution {
    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     * Assumes that both nodes exist in the BST.
     * 
     * @param root The root node of the BST.
     * @param p The first node.
     * @param q The second node.
     * @return The lowest common ancestor of nodes p and q, or null if root/p/q is null.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root, p, or q is null, return null (invalid case handling)
        if (root == null || p == null || q == null) {
            return null;
        }

        // If both p and q are smaller than root, LCA is in the left subtree.
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        
        // If both p and q are greater than root, LCA is in the right subtree.
        else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        
        // If one value is smaller and the other is greater, the current root is the LCA.
        else {
            return root;
        }
    }
}
