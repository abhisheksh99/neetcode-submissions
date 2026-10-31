class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of numbers in array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Missing number
        return expectedSum - actualSum;
    }
}