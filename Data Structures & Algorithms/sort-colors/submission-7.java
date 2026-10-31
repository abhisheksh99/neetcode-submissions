class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int start = 0, end = nums.length - 1, index = 0;

        while (index <= end) {
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
                start++;
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                index++;
            }
        }
    }
}
