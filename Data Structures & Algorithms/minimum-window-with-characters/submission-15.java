class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";

        int[] target = new int[128];
        for (char c : t.toCharArray()) target[c]++;

        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            // Expand window by including s.charAt(right)
            if (target[s.charAt(right)] > 0) count--;
            target[s.charAt(right)]--;
            right++;

            // Try to shrink window if all chars are matched
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                target[s.charAt(left)]++;
                if (target[s.charAt(left)] > 0) count++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
