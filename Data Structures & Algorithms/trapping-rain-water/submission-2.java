class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; // Edge case: No bars, no water
        }

        int left = 0; // Pointer starting at the left end
        int right = height.length - 1; // Pointer starting at the right end

        int total = 0; // Variable to store the total trapped water
        int leftMax = height[0]; // Maximum height on the left side
        int rightMax = height[right]; // Maximum height on the right side

        while (left < right) { // Iterate until the two pointers meet
            if (height[left] < height[right]) {
                // Update the left maximum height
                leftMax = Math.max(leftMax, height[left]);

                // Calculate trapped water at the current left position
                total += Math.max(0, leftMax - height[left]);

                // Move the left pointer
                left++;
            } else {
                // Update the right maximum height
                rightMax = Math.max(rightMax, height[right]);

                // Calculate trapped water at the current right position
                total += Math.max(0, rightMax - height[right]);

                // Move the right pointer
                right--;
            }
        }
        return total; // Return the total trapped water
    }
}
