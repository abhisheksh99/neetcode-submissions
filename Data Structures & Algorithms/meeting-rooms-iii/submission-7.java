

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Available rooms (min-heap by room number)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);

        // Ongoing meetings (min-heap by [endTime, roomNumber])
        PriorityQueue<long[]> ongoing = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];
            long duration = end - start;

            // Free up rooms that are done before this meeting starts
            while (!ongoing.isEmpty() && ongoing.peek()[0] <= start) {
                available.offer((int) ongoing.poll()[1]);
            }

            if (available.isEmpty()) {
                // All rooms are busy → take the one that frees up the earliest
                long[] next = ongoing.poll();
                long newEnd = next[0] + duration;
                ongoing.offer(new long[]{newEnd, next[1]});
                count[(int) next[1]]++;
            } else {
                // Assign the lowest-numbered available room
                int room = available.poll();
                ongoing.offer(new long[]{end, room});
                count[room]++;
            }
        }

        // Find the room with the maximum meetings (lowest index on tie)
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }

        return ans;
    }
}
