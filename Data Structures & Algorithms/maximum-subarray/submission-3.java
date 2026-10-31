class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0;
        int maxSub = nums[0];

        for(int num:nums){
            if(currSum<0){
                currSum=0;
            }
            currSum +=num;
            maxSub=Math.max(maxSub,currSum);
        }
        return maxSub;
        
    }
}
