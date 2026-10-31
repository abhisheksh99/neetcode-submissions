class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxA=0;

        while(left<right){
            int area = Math.min(heights[left],heights[right])*(right-left);
            maxA= Math.max(maxA,area);
            if(heights[left]<heights[right]){
                left++;
            }else {
                right--;
            }

        }
        return maxA;
        
    }
}
