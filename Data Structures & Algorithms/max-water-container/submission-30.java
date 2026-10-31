class Solution {
    public int maxArea(int[] heights) {
        int maxA=0,left=0,right=heights.length-1;

        while(left<right){
            int area=Math.min(heights[left],heights[right])*(right-left);
            maxA=Math.max(area,maxA);
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxA;
    }
}
