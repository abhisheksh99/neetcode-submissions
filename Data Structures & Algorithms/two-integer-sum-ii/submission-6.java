class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum < target) {
                left++;  // Need larger sum, move left pointer right
            } else if (currSum > target) {
                right--; // Need smaller sum, move right pointer left
            } else {
                return new int[]{left + 1, right + 1}; // Found target, return 1-indexed positions
            }
        }
        return new int[0]; // No solution found (though problem guarantees one exists)
    }
}