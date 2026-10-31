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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> height = new HashMap<>();
        TreeNode curr = root, lastVisited = null;

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
                    if (Math.abs(leftH - rightH) > 1) return false;
                    height.put(node, 1 + Math.max(leftH, rightH));
                    lastVisited = node;
                }
            }
        }

        return true;
    }
}
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;
//         int leftHeight=getHeight(root.left);
//         int rightHeight=getHeight(root.right);
//         if(Math.abs(leftHeight-rightHeight)>1){
//             return false;
//         }
//         return isBalanced(root.left) && isBalanced(root.right);
        
//     }
//     private int getHeight(TreeNode node){
//         if(node ==null) return 0;
//         int leftHeight=getHeight(node.left);
//         int rightHeight=getHeight(node.right);
//         return 1+Math.max(leftHeight,rightHeight);
//     }
// }
