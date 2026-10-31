class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,currSum=0,right=0,maxLen=Integer.MAX_VALUE;
        for(right=0;right<nums.length;right++){
            currSum+=nums[right];
            while(currSum>=target){
                maxLen=Math.min(maxLen,right-left+1);
                currSum-=nums[left];
                left++;
            }
            
        }
        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}