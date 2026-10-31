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

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        order(root, 0);
        return res;
    }

    private void order(TreeNode node, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(node.val);

        if (node.left != null) {
            order(node.left, level + 1);
        }
        if (node.right != null) {
            order(node.right, level + 1);
        }
    }
}

