class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];
        int time = 0, index = 0;
        
        // Add original index to each task to remember order
        for (int i = 0; i < n; ++i)
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (i < n && time < tasks[i][0]) time = tasks[i][0];
            while (i < n && tasks[i][0] <= time) {
                pq.offer(tasks[i++]);
            }
            if (pq.isEmpty()) {
                time = tasks[i][0];
                pq.offer(tasks[i++]);
            }
            int[] current = pq.poll();
            result[index++] = current[2];
            time += current[1];
        }
        return result;
    }
}