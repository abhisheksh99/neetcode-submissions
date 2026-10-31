class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)  // Min-Heap based on frequency
        );

        for (int n : count.keySet()) {  // Fixed keySet() method call
            heap.add(n);
            if (heap.size() > k) {  // Fixed size() method call
                heap.poll();  // Fixed poll() method call
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();  // Fixed poll() method call
        }

        return ans;  // Added return statement
    }
}