class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. drop smaller values from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            // 2. add current index
            dq.offerLast(i);

            // 3. drop front if it left the window
            if (dq.peekFirst() <= i - k) dq.pollFirst();

            // 4. record the max
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
}