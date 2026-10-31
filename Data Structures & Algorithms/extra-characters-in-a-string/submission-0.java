class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictionarySet = new HashSet<>();
        for (String word : dictionary) {
            dictionarySet.add(word);
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;  // base case: empty string has 0 extra chars
        
        for (int i = 1; i <= n; i++) {
            // Option 1: treat s[i-1] as extra character
            dp[i] = dp[i - 1] + 1;
            
            // Option 2: try to form a dictionary word ending at i-1 index
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dictionarySet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        return dp[n];
    }
}