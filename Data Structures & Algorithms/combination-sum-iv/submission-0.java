public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(target, 1);
        for (int total = target; total > 0; total--) {
            for (int num : nums) {
                if (total < num) break;
                dp.put(total - num, dp.getOrDefault(total, 0) + dp.getOrDefault(total - num, 0));
            }
        }
        return dp.getOrDefault(0, 0);
    }
}