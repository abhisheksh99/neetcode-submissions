class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int remaining = t.length();
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (freq[rightChar] > 0) {
                remaining--;
            }
            freq[rightChar]--;

            while (remaining == 0) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    remaining++;
                }
                left++;
            }
        }

        return minWindowLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
