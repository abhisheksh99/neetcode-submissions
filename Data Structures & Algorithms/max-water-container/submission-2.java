class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int res = 0;

        while (left < right) {
            // Calculate the area between the two pointers
            int area = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(res, area);

            // Move the pointer with the smaller height
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res; // Return the maximum area
    }
}
