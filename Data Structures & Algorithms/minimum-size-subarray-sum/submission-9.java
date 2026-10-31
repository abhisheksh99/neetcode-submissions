class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,minLenWindow=Integer.MAX_VALUE,currSum=0;

        for(right=0;right<nums.length;right++){
            currSum+=nums[right];
            while(currSum>=target){
                minLenWindow=Math.min(right-left+1,minLenWindow);
                currSum-=nums[left];
                left++;
            }
        }
        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}