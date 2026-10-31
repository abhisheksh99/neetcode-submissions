class Solution {
    public int shipWithinDays(int[] weights, int days) {
               int minCap = 0;
        int maxCap = 0;

        for (int weight : weights) {
            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }

        while (minCap < maxCap) {
            int mid = minCap + (maxCap - minCap) / 2;

            int usedDays = 1;  // renamed to avoid shadowing parameter
            int sum = 0;

            for (int weight : weights) {
                if (sum + weight > mid) {
                    usedDays++;
                    sum = 0;
                }
                sum += weight;
            }

            if (usedDays > days) {  // replaced D with days (your parameter)
                minCap = mid + 1;
            } else {
                maxCap = mid;
            }
        }

        return minCap;
        
    }
}