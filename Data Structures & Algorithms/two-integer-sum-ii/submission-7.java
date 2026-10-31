class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // Since the array is sorted, use two pointers to find the pair
        while (left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum < target) {
                left++; // Need a larger sum, move left pointer
            } else if (currSum > target) {
                right--; // Need a smaller sum, move right pointer
            } else {
                return new int[]{left + 1, right + 1}; // Found the pair, return 1-based indices
            }
        }
        return new int[0]; // Fallback return, though the problem guarantees a solution exists
    }
}