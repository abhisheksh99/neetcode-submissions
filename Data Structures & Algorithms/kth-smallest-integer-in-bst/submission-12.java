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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = inOrder(root,new ArrayList<>());
        return res.get(k-1);
        
    }
    public List<Integer> inOrder(TreeNode node,List<Integer> arr){
        if(node==null) return arr;
        inOrder(node.left,arr);
        arr.add(node.val);
        inOrder(node.right,arr);
        return arr;
    }
}
