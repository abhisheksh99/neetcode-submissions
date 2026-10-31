class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> arr = new HashMap<>();
        arr.put(0, 1); 
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (arr.containsKey(sum - k)) {
                result += arr.get(sum - k);
            }
            arr.put(sum, arr.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
