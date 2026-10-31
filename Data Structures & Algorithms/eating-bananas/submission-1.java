class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Define the search range: minimum speed is 1, maximum speed is the largest pile
        int left = 1, right = 0;
        
        // Find the largest pile (upper bound for binary search)
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Apply binary search to find the minimum eating speed
        while (left < right) {
            int mid = (left + right) / 2; // Middle speed to test

            // Check if Koko can finish eating all bananas within h hours
            if (canFinish(piles, mid, h)) {
                right = mid; // Try a lower speed
            } else {
                left = mid + 1; // Increase speed
            }
        }
        return left; // Left is now the minimum possible eating speed
    }

    // Helper function to check if Koko can finish all bananas in h hours
    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        
        for (int pile : piles) {
            // Calculate time required to finish each pile at 'speed'
            hours += (int) Math.ceil((double) pile / speed);
        }
        
        // Return true if Koko can finish in the given hours
        return hours <= h;
    }
}
