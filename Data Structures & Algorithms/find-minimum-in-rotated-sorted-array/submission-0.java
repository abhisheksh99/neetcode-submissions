class Solution {
    public int findMin(int[] nums) {
        int left = 0; // Initialize the left pointer
        int right = nums.length - 1; // Initialize the right pointer
        int ans = nums[0]; // Initialize the answer with the first element

        // If the array has only one element, return it as the minimum
        if (nums.length == 1) {
            return nums[0];
        }

        // Binary search to find the minimum in the rotated sorted array
        while (left <= right) {
            // If the array is already sorted in the current range, the leftmost element is the smallest
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break; // Exit the loop as we found the smallest element
            }

            // Calculate the middle index
            int mid = (left + right) / 2;

            // Update the answer with the smallest value between `ans` and the current mid element
            ans = Math.min(ans, nums[mid]);

            // Determine which part of the array to search next
            if (nums[left] <= nums[mid]) {
                // If the left half is sorted, move to the unsorted right half
                left = mid + 1;
            } else {
                // If the right half is unsorted, move to the left half
                right = mid - 1;
            }
        }

        return ans; // Return the smallest value found
    }
}
