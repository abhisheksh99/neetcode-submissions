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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        // Base case: no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) return null;

        // The first element in preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the root index in inorder array
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != rootVal) {
            rootIndex++;
        }

        // Count nodes in the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          inorder, inStart, rootIndex - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                           inorder, rootIndex + 1, inEnd);

        return root;
    }
}
