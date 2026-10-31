public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        // If the array is not rotated
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half including mid
                right = mid;
            }
        }
        return nums[left];
    }
}
