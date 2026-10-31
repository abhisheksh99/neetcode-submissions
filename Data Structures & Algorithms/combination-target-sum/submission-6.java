class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<>();
        backtrack(target,res,comb,0,nums);
        return res;
        
    }
    public void backtrack(int target, List<List<Integer>> res, List<Integer> comb, int start, int[] nums){
        if(target==0){
            res.add(new ArrayList<>(comb));
        }
        else if(target<0){
            return;
        }

        for(int i=start;i<nums.length;i++){
            comb.add(nums[i]);
            backtrack(target-nums[i],res,comb,i,nums);
            comb.remove(comb.size()-1);
        }

    }
}
