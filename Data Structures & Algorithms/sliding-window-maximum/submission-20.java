class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;                          
        int[] res = new int[n - k + 1];              
        int j = 0;                                   

        ArrayDeque<Integer> queue = new ArrayDeque<>(); 

        for (int i = 0; i < n; i++) {
            // Remove indices from back while current value is greater
            // to maintain decreasing order in the deque
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }

            // Add current index to the back
            queue.addLast(i);

            // Remove the front index if it is out of this window (i - k + 1 is window start)
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }

            // Once first window is formed (i >= k - 1), record the maximum for this window
            if (i >= k - 1) {
                res[j++] = nums[queue.getFirst()];  // front of deque is max in current window
            }
        }

        return res;
    }
}