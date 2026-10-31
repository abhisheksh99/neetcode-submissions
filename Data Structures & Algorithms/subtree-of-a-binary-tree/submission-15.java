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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node == null) continue;

            // If values match, check if the two trees are identical
            if (node.val == subRoot.val && isSameTree(node, subRoot)) {
                return true;
            }

            stack.push(node.left);
            stack.push(node.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0], node2 = nodes[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            stack.push(new TreeNode[]{node1.left, node2.left});
            stack.push(new TreeNode[]{node1.right, node2.right});
        }

        return true;
    }
}

// class Solution {

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if (subRoot == null) {
//             return true;
//         }
//         if (root == null) {
//             return false;
//         }

//         if (sameTree(root, subRoot)) {
//             return true;
//         }
//         return isSubtree(root.left, subRoot) ||
//                isSubtree(root.right, subRoot);
//     }

//     public boolean sameTree(TreeNode root, TreeNode subRoot) {
//         if (root == null && subRoot == null) {
//             return true;
//         }
//         if (root != null && subRoot != null && root.val == subRoot.val) {
//             return sameTree(root.left, subRoot.left) &&
//                    sameTree(root.right, subRoot.right);
//         }
//         return false;
//     }
// }