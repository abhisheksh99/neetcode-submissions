class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001]; // Since 0 <= from, to <= 1000

        // Step 1: Mark the passenger changes
        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += num; // passengers get in
            stops[to] -= num;   // passengers get out
        }

        // Step 2: Simulate the journey
        int currPassengers = 0;
        for (int i = 0; i < 1001; i++) {
            currPassengers += stops[i];
            if (currPassengers > capacity) return false;
        }

        return true;
    }
}