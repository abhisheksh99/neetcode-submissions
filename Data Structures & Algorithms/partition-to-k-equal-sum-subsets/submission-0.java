public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % k != 0) return false;  // can't divide evenly
        
        int target = totalSum / k;
        Arrays.sort(nums);
        reverse(nums); // Sort descending to optimize pruning
        
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, k, 0, 0, target);
    }
    
    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currentSum, int target) {
        if (k == 0) return true;  // all subsets formed
        
        if (currentSum == target)
            // current subset complete, go for the next subset
            return backtrack(nums, visited, k - 1, 0, 0, target);
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;
                if (backtrack(nums, visited, k, i + 1, currentSum + nums[i], target))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
    
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}