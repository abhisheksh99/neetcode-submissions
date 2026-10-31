class Solution {

    // Helper function to check if we can split nums into at most k subarrays
    // with each subarray sum ≤ target
    private boolean canSplit(int[] nums, int k, int target) {
        int currentSum = 0, count = 1;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > target) {
                // Start new subarray
                currentSum = num;
                count++;
                if (count > k) return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num); // max element
            right += num;               // sum of all elements
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;  // try to find smaller max sum
            } else {
                left = mid + 1;  // increase max sum
            }
        }
        return left;  // minimum largest sum possible
    }
}
