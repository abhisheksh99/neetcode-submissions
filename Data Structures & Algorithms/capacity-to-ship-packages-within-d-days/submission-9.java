class Solution {
    public int shipWithinDays(int[] weights, int days) {

        // Minimum capacity must be at least the heaviest package.
        int minCap = 0;

        // Maximum capacity is the sum of all packages.
        int maxCap = 0;

        for (int weight : weights) {
            minCap = Math.max(minCap, weight);   // cannot carry less than the heaviest item
            maxCap += weight;                    // at most carry all at once
        }

        // Binary search for minimal ship capacity
        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2; // test capacity

            int usedDays = 1;   // days needed with current capacity
            int sum = 0;        // current day's load

            for (int weight : weights) {
                // If adding this weight exceeds capacity, start next day
                if (sum + weight > mid) {
                    usedDays++;
                    sum = 0;
                }
                sum += weight;
            }

            // If we use more days than allowed, capacity is too small
            if (usedDays > days) {
                minCap = mid + 1;
            }
            // Otherwise mid works, try to lower it
            else {
                maxCap = mid;
            }
        }

        // minCap is the smallest capacity that ships all packages in given days
        return minCap;
    }
}
