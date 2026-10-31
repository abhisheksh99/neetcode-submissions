class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // update left max
                } else {
                    water += leftMax - height[left]; // trapped water at left
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update right max
                } else {
                    water += rightMax - height[right]; // trapped water at right
                }
                right--;
            }
        }

        return water;
    }
}
