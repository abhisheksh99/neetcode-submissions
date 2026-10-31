class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count how many times each task appears
        Map<Character, Integer> taskFrequency = new HashMap<>();
        for (char task : tasks) {
            taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
        }

        // Step 2: Create a max heap (most frequent tasks first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(taskFrequency.values());

        // Step 3: Keep track of total time units
        int totalTime = 0;

        // Step 4: Process tasks in cycles of (n + 1)
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            // Try to schedule up to (n + 1) tasks in this cycle
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    tempList.add(maxHeap.poll());
                }
            }

            // Step 5: Decrease frequency and re-add unfinished tasks
            for (int freq : tempList) {
                if (freq - 1 > 0) {
                    maxHeap.add(freq - 1);
                }
            }

            // Step 6: If the heap is empty, just add the number of tasks processed.
            // Otherwise, a full cycle (n + 1) is required.
            totalTime += maxHeap.isEmpty() ? tempList.size() : n + 1;
        }

        return totalTime;
    }
}