class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Minimum eating speed is at least 1 banana per hour.
        int minSpeed = 1;

        // Maximum eating speed is the largest pile (eat it in 1 hour).
        int maxSpeed = 0;

        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);  // cannot eat faster than the largest pile size
        }

        // Binary search for minimal eating speed
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2; // test eating speed

            int hours = 0; // total hours required at this speed

            for (int pile : piles) {
                // Time to finish this pile at speed mid
                hours += Math.ceil((double) pile / mid);
            }

            // If Koko needs more than h hours, speed is too slow
            if (hours > h) {
                minSpeed = mid + 1;
            }
            // Otherwise mid works, try to lower it
            else {
                maxSpeed = mid;
            }
        }

        // minSpeed is the minimum speed to finish all piles within h hours
        return minSpeed;
    }
}
