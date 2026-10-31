class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize slow and fast pointers.
        // Slow moves one step at a time, fast moves two steps at a time.
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Phase 1: Detect the intersection point (cycle detection).
        while (slow != fast) {
            // Move slow pointer one step at a time.
            slow = nums[slow];
            // Move fast pointer two steps at a time.
            fast = nums[nums[fast]];
        }

        // Phase 2: Find the entrance to the cycle (duplicate number).
        // Set slow pointer to the start of the array.
        slow = 0;
        
        // Move both pointers one step at a time until they meet.
        while (slow != fast) {
            // Move slow pointer one step at a time.
            slow = nums[slow];
            // Move fast pointer one step at a time.
            fast = nums[fast];
        }

        // When slow and fast meet, we found the duplicate number.
        return slow;
    }
}
