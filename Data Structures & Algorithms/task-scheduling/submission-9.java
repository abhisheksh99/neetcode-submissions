class Solution {
public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) freq[c - 'A']++;

    // Max heap to pick the most frequent task first
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int f : freq) if (f > 0) maxHeap.add(f);

    int time = 0;

    while (!maxHeap.isEmpty()) {
        List<Integer> waitList = new ArrayList<>();
        int slots = n + 1;

        // Fill up to n+1 slots with most common tasks
        while (slots > 0 && !maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            if (current > 1) waitList.add(current - 1);
            time++;
            slots--;
        }

        // Put remaining tasks back in the heap
        for (int count : waitList) maxHeap.add(count);

        // If heap is empty, we're done; otherwise, account for idle time
        if (!maxHeap.isEmpty()) time += slots;
    }

    return time;
}

}
