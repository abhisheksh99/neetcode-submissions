class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++; // store frequency of target string
        }

        int left = 0, right = 0, required = t.length();
        int minStart = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            if (need[s.charAt(right)] > 0) {
                required--; // one needed char is satisfied
            }
            need[s.charAt(right)]--; // mark char as used
            right++;

            // when all chars are found
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) {
                    required++; // we lost a needed char
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
