class Solution {
    public int rob(TreeNode root) {
        int[] result = robWithRootAndWithoutRoot(root);
        return Math.max(result[0], result[1]);
    }
    
    // result[0]: max money without robbing current node (withoutRoot)
    // result[1]: max money with robbing current node (withRoot)
    private int[] robWithRootAndWithoutRoot(TreeNode node) {
        if (node == null) return new int[2];

        int[] left = robWithRootAndWithoutRoot(node.left);
        int[] right = robWithRootAndWithoutRoot(node.right);

        int withRoot = node.val + left[0] + right[0]; // Cannot rob children
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // May rob children

        return new int[]{withoutRoot, withRoot};
    }
}
