class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res,new ArrayList<>(),nums,used);
        return res;
        
    }
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] used){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                curr.add(nums[i]);
                used[i]=true;
                backtrack(res,curr,nums,used);
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}
