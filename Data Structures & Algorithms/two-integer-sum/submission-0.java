class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int reqNum = target - nums[i];
            if (hashMap.containsKey(reqNum)) {
                return new int[] {hashMap.get(reqNum), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
