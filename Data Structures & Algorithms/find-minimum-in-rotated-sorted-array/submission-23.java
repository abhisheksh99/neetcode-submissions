class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If array not rotated, first element is minimum
        if (nums[left] <= nums[right]) return nums[left];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;     // min is to the right of mid
            } else {
                right = mid;        // mid could be the min, keep it
            }
        }
        return nums[left];
    }
}