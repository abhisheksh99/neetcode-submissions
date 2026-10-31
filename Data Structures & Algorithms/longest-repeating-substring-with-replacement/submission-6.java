class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> occurrence = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurrence = 0;
        
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            occurrence.put(c, occurrence.getOrDefault(c, 0) + 1);
            maxOccurrence = Math.max(maxOccurrence, occurrence.get(c));
            
            if (right - left + 1 - maxOccurrence > k) {
                char leftChar = s.charAt(left);
                occurrence.put(leftChar, occurrence.get(leftChar) - 1);
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}