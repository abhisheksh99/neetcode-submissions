class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            for (int f : temp) {
                if (f - 1 > 0) {
                    pq.add(f - 1);
                }
            }

            if (pq.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}
