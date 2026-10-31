class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            // If frequency > n/2, we can return immediately
            if (count.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1; // should never happen since majority element always exists
    }
}