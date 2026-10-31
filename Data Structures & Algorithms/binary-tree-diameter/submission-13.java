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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> height = new HashMap<>();
        TreeNode curr = root, lastVisited = null;
        int diameter = 0;

        // iterative post-order
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && lastVisited != node.right) {
                    curr = node.right;
                } else {
                    stack.pop();
                    int leftH = node.left == null ? 0 : height.get(node.left);
                    int rightH = node.right == null ? 0 : height.get(node.right);
                    int currH = 1 + Math.max(leftH, rightH);
                    height.put(node, currH);
                    diameter = Math.max(diameter, leftH + rightH);
                    lastVisited = node;
                }
            }
        }

        return diameter;
    }
}
// class Solution {
//     int maxDiameter=0;
//     public int diameterOfBinaryTree(TreeNode root) {
//         getHeight(root);
//         return maxDiameter;

//     }
//     private int getHeight(TreeNode node){
//         if(node==null) return 0;
//         int leftHeight=getHeight(node.left);
//         int rightHeight=getHeight(node.right);
//         maxDiameter=Math.max(maxDiameter,leftHeight+rightHeight);
//         return 1+Math.max(leftHeight,rightHeight);

//     }
// }
