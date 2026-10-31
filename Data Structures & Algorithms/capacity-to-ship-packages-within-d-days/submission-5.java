class Solution {
    private boolean canShip(int[] weights, int capacity, int days) {
        int dayCount = 1, load = 0;
        for (int weight : weights) {
            load += weight;
            if (load > capacity) {
                dayCount++;
                load = weight;
                if (dayCount > days) return false;
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight, right = totalWeight;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
