/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        // Step 1: Find the peak index of the mountain array
        int n = mountainArr.length();
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is increasing slope, peak is to the right
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } 
            // Otherwise, peak is at mid or to its left
            else {
                right = mid;
            }
        }

        int peak = left;

        // Step 2: Binary search on the increasing part (0 → peak)
        left = 0; 
        right = peak;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }

        // Step 3: Binary search on the decreasing part (peak → end)
        left = peak + 1;
        right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) return mid;
            // reversed comparison because this half is strictly decreasing
            if (val > target) left = mid + 1;
            else right = mid - 1;
        }

        // Target was not found
        return -1;
    }
}
