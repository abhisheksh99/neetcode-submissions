class Solution {
    public int splitArray(int[] nums, int k) {
        
    int left = 0;
    int right = 0;

    for (int n : nums) {
        left = Math.max(left, n);
        right += n;
    }

    while (left < right) {
        int mid = left + (right - left) / 2;

        int pieces = 1;
        int sum = 0;
        for (int n : nums) {
            if (sum + n > mid) {
                pieces++;
                sum = 0;
            }
            sum += n;
        }

        if (pieces > k) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}
}
