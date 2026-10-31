class Solution {
    private boolean canSplit(int[] nums, int k, int target) {
        int currentSum = 0, count = 1;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > target) {
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
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
