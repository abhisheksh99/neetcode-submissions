class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);

            if(map.get(num)>nums.length/2){
                return num;
            }
        }

        return -1;
        
    }
}
// class Solution {
//     public int majorityElement(int[] nums) {
//         int candidate = 0;
//         int count = 0;

//         // 1st pass: find candidate
//         for (int num : nums) {
//             if (count == 0) {
//                 candidate = num;      // choose new candidate
//                 count = 1;
//             } else if (num == candidate) {
//                 count++;              // same as candidate: increase vote
//             } else {
//                 count--;              // different: cancel out one vote
//             }
//         }

//         // For LeetCode 169 majority is guaranteed, so candidate is the answer.
//         return candidate;
//     }
// }
