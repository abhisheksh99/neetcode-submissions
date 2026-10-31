class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number x to index x-1, if possible
        for (int i = 0; i < n; i++) {
            // while current value is in [1, n] and not at its correct position
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                // swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find first index where value != index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are correct, missing is n+1
        return n + 1;
    }
}

// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num:nums){
//             set.add(num);
//         }

//         int num=1;
//         for(int i=0;i<nums.length;i++){
//             if(!set.contains(num)){
//                 return num;
//             }
//             num++;
//         }
//         return num;
//     }
// }