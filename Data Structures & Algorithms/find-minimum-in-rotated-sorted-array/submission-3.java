class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        // If the array contains only one element, return it directly
        if (nums.length == 1) {
            return nums[0];
        }

        // Binary search to find the minimum element in the rotated sorted array
        while (left <= right) {
            // If the subarray is already sorted, return the leftmost element
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break; // No need to continue searching
            }

            int mid = left + (right - left) / 2; // Avoids integer overflow
            ans = Math.min(ans, nums[mid]);

            // If mid element is greater than the rightmost element, search the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Otherwise, search the left half
                right = mid - 1;
            }
        }
        return ans;
    }
}
