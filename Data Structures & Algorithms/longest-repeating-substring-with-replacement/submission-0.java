class Solution {
    public int characterReplacement(String s, int k) {
        // Array to store the frequency of each character in the current window
        int[] occurance = new int[26];
        
        // Initialize the left and right pointers for the sliding window
        int left = 0, right = 0;
        
        // Variable to store the maximum length of the substring found
        int ans = 0;
        
        // Variable to track the maximum frequency of a single character in the current window
        int maxOccurance = 0;
        
        // Expand the sliding window by moving the right pointer
        for (right = 0; right < s.length(); right++) {
            // Increment the frequency of the current character
            maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right) - 'A']);
            
            // Check if the current window (right - left + 1) minus the most frequent character
            // exceeds the allowed number of replacements (k)
            if (right - left + 1 - maxOccurance > k) {
                // Reduce the frequency of the character at the left pointer
                occurance[s.charAt(left) - 'A']--;
                
                // Move the left pointer to shrink the window
                left++;
            }
            
            // Update the answer with the maximum size of the valid window
            ans = Math.max(ans, right - left + 1);
        }
        
        // Return the maximum length of the substring found
        return ans;
    }
}
