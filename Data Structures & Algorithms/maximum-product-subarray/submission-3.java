class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int min = nums[0];  // min product ending at current position
        int max = nums[0];  // max product ending at current position
        int result = nums[0];  // global max product
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // Candidates for new max/min at current position
            int tempMax = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = tempMax;
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}
