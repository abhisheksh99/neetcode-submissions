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

    public ArrayList<Integer> Inorder(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return arr;
        }
        Inorder(root.left,arr);
        arr.add(root.val);
        Inorder(root.right,arr);
        return arr;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = Inorder(root,new ArrayList<>());
        return nums.get(k-1);

        
    }
}
