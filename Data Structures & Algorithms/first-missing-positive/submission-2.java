class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int val = 1;
        for (int i = 0;i<nums.length;i++){
            if(!set.contains(val)){
                return val;
            }
            val++;
        }
        return  val;
    }
}