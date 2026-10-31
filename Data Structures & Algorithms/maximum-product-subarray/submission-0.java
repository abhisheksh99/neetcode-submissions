class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int minProd = nums[0]; // Minimum product ending at current index
        int maxProd = nums[0]; // Maximum product ending at current index
        int result = maxProd;  // Global maximum product
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // Store maxProd to avoid overwriting in minProd calculation
            int temp = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            // Update minProd: min of current number or product with prev max/min
            minProd = Math.min(curr, Math.min(minProd * curr, maxProd * curr));
            // Update maxProd
            maxProd = temp;
            // Update global maximum
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}