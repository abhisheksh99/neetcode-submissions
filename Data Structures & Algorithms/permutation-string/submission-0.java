class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, s1 cannot be a permutation of any substring of s2
        if (s1.length() > s2.length()) {
            return false;
        }
        
        // Frequency arrays to store character counts for s1 and the current window of s2
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Populate the frequency arrays for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++; // Count characters in s1
            s2Map[s2.charAt(i) - 'a']++; // Count characters in the first window of s2
        }

        // Slide the window over s2, starting from the end of the first window
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // Check if the current window matches the frequency of s1
            if (matches(s1Map, s2Map)) {
                return true;
            }
            
            // Slide the window by adding the next character and removing the first character
            s2Map[s2.charAt(i + s1.length()) - 'a']++; // Add the next character to the window
            s2Map[s2.charAt(i) - 'a']--; // Remove the first character from the window
        }

        // Perform one last check for the final window
        return matches(s1Map, s2Map);
    }

    // Helper method to check if two frequency arrays match
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false; // If any character count does not match, return false
            }
        }
        return true; // All character counts match
    }
}
