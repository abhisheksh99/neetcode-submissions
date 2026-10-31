
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store the number and its index
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i]; // Calculate the complement of the current number
            
            // If the complement is already in the map, we found the two numbers
            if (map.containsKey(component)) {
                return new int[] {map.get(component), i}; // Return the indices of the two numbers
            }
            
            // Add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array (this case shouldn't happen in valid input)
        return new int[0];
    }
}
