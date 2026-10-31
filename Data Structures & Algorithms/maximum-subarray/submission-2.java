class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSub = nums[0]; // Initialize with first element
        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0; // Reset currSum if it becomes negative
            }
            currSum += num; // Add current number to currSum
            maxSub = Math.max(maxSub, currSum); // Update maxSub if currSum is larger
        }
        return maxSub;
    }
}