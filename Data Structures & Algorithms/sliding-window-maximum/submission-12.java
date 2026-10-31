class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // One max per window
        Deque<Integer> deque = new ArrayDeque<>();  // Will store indices

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indices that are out of the current window
            // (i - k) is the start of current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();  // Remove old index
            }

            // Step 2: Remove indices of smaller elements from the back
            // These can't be max as long as nums[i] is in the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();   // Remove useless smaller number
            }

            // Step 3: Add current index
            deque.offerLast(i);

            // Step 4: After first (k-1) elements, start recording max
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];  // Front is max
            }
        }

        return result;
    }
}