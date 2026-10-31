class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> occurence = new HashMap<>();
        int left = 0, right = 0, ans = 0, maxOccurence = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            occurence.put(c, occurence.getOrDefault(c, 0) + 1);

            maxOccurence = Math.max(maxOccurence, occurence.get(c));

            if (right - left + 1 - maxOccurence > k) {
                char leftChar = s.charAt(left);
                occurence.put(leftChar, occurence.get(leftChar) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1); 
            right++;
        }
        return ans;
    }
}
