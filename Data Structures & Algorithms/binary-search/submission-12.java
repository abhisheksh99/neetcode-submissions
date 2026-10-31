class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            int mid=(right+left)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]<target){
                left++;
            }else{
                right--;
            }
        }
        return -1;
        
    }
}
