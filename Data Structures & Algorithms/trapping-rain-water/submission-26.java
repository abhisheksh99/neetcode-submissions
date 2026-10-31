class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1, total = 0;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return total;
    }
}