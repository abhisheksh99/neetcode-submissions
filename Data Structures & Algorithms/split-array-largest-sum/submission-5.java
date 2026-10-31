class Solution {
    public int splitArray(int[] nums, int k) {

        // The smallest possible largest subarray sum 
        // must be at least the maximum single number.
        int left = 0;

        // The largest possible largest subarray sum 
        // is the sum of the entire array.
        int right = 0;

        for (int n : nums) {
            left = Math.max(left, n);   // cannot split below the max element
            right += n;                 // worst case: one subarray
        }

        // Binary search for the minimum valid largest-sum
        while (left < right) {
            int mid = left + (right - left) / 2; // candidate largest sum

            int pieces = 1;  // number of subarrays needed
            int sum = 0;

            // Greedily form subarrays
            for (int n : nums) {
                // If adding this number exceeds the limit (mid)
                // we start a new subarray.
                if (sum + n > mid) {
                    pieces++;
                    sum = 0;
                }
                sum += n;
            }

            // If more than k subarrays are needed,
            // mid is too small, so increase left bound.
            if (pieces > k) {
                left = mid + 1;
            } 
            // Otherwise, mid works, try smaller value.
            else {
                right = mid;
            }
        }

        // left is now the smallest possible largest subarray sum
        return left;
    }
}
