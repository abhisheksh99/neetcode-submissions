

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count how many times each task appears
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Use a max heap to always pick the most frequent remaining task
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        // Step 3: Initialize total time counter
        int time = 0;

        // Step 4: Process tasks in cycles of (n + 1)
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); // to store remaining counts after this cycle

            // Try to execute up to (n + 1) tasks in one cycle
            for (int i = 0; i < n + 1 && !maxHeap.isEmpty(); i++) {
                temp.add(maxHeap.poll()); // take the most frequent task
            }

            // Decrease frequency and reinsert unfinished tasks
            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // If heap is empty → last cycle; count only executed tasks
            // Otherwise → count full cycle (n + 1)
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        // Step 5: Return total time
        return time;
    }
}
