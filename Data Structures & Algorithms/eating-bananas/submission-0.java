class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize the minimum possible speed (left) to 1 and the maximum possible speed (right)
        int left = 1;
        int right = 0; // The maximum possible speed is the size of the largest pile

        // Find the largest pile to determine the upper limit of the eating speed
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Perform binary search to find the minimum eating speed
        while (left < right) { // Loop until the search range converges
            int mid = (left + right) / 2; // Calculate the midpoint speed

            // Check if Koko can finish all piles at the current speed (mid) within h hours
            if (canFinish(piles, mid, h)) {
                // If possible, try smaller speeds to find the minimum
                right = mid;
            } else {
                // If not possible, increase the speed
                left = mid + 1;
            }
        }

        // At the end of the loop, left will hold the minimum speed
        return left;
    }

    // Helper function to determine if Koko can finish all piles at a given speed within h hours
    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0; // Initialize the total hours required

        // Iterate through each pile
        for (int pile : piles) {
            // Calculate the number of hours needed to eat this pile at the given speed
            // (pile + speed - 1) / speed performs ceiling division without using floating-point arithmetic
            hours += (pile + speed - 1) / speed;
        }

        // Return true if the total hours needed is within the allowed hours (h)
        return hours <= h;
    }
}
