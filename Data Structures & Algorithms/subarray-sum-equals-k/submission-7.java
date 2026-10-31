class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initial prefix sum of 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // Check if (sum - k) appeared before, add its count to result
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // Store/Update current prefix sum count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
