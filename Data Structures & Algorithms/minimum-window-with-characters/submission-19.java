class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] window = new int[128];
        int required = t.length();

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (right = 0; right < s.length(); right++) {
            char c1 = s.charAt(right);

            if (need[c1] > 0 && window[c1] < need[c1]) {
                required--;
            }
            window[c1]++;

            while (required == 0 && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char c2 = s.charAt(left);
                window[c2]--;
                if (window[c2] < need[c2]) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
