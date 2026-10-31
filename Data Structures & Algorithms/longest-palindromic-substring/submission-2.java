class Solution {

    public String longestPalindrome(String s) {
        // Base case: empty or null string
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        // Expand around each character as a potential palindrome center
        for (int i = 0; i < s.length(); i++) {
            // Case 1: odd-length palindrome (single center)
            int len1 = expandFromCenter(s, i, i);
            // Case 2: even-length palindrome (two-character center)
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update the longest palindrome boundaries
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Helper method: expands from the given center and returns palindrome length
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Subtract 1 because we go one step too far in both directions
        return right - left - 1;
    }
}
