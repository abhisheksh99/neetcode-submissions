class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int start = 0, end = nums.length - 1;
        int index = 0;

        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, start);
                start++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
