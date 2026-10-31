class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int count = 0;

        // Try every possible center
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            count += expandFromCenter(s, i, i);
            // Even-length palindromes
            count += expandFromCenter(s, i, i + 1);
        }

        return count;
    }

    // Helper: expand around center and return number of palindromes found
    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;   // Found one palindrome
            left--;
            right++;
        }
        return count;
    }
}
