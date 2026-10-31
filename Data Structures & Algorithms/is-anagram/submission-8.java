class Solution {
    public boolean isAnagram(String s, String t) {
        // If the lengths of both strings are not equal, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Array to store the frequency of characters (assuming lowercase letters)

        // Iterate through both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment count for character in string s
            charCount[t.charAt(i) - 'a']--; // Decrement count for character in string t
        }

        // Check if all character frequencies are zero
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false; // If any count is non-zero, s and t are not anagrams
            }
        }
        
        return true; // Strings are anagrams
    }
}
