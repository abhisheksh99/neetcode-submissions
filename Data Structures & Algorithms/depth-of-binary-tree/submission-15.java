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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        nodeStack.push(root);
        depthStack.push(1);

        int res = 0;

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int currDepth = depthStack.pop();

            res = Math.max(res, currDepth);

            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(currDepth + 1);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(currDepth + 1);
            }
        }

        return res;
    }
}

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root==null) {
//             return 0;
//         }
//         return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//     }
// }
