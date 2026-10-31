class Solution {
    public int search(int[] nums, int target) {
        int left = 0; // Initialize the left pointer
        int right = nums.length - 1; // Initialize the right pointer

        // Perform binary search
        while (left <= right) {
            // Calculate the middle index
            int mid = (left + right) / 2;

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid; // Return the index of the target
            }

            // Determine if the left portion is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target lies outside the range of the sorted left portion
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1; // Search in the right portion
                } else {
                    right = mid - 1; // Search in the left portion
                }
            } 
            // Otherwise, the right portion must be sorted
            else {
                // Check if the target lies outside the range of the sorted right portion
                if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1; // Search in the left portion
                } else {
                    left = mid + 1; // Search in the right portion
                }
            }
        }

        // If the loop ends, the target is not in the array
        return -1;
    }
}
