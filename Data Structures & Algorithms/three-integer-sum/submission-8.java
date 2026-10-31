class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // Skip duplicates
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum2(nums, i, result);
            }
        }
        return result;
    }

    private void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                // Add the triplet to the result list
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // Skip duplicates for `left` and `right`
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;

                // Move pointers inward
                left++;
                right--;
            }
        }
    }
}
