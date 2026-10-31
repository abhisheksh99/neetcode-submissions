class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0; // number of reachable positions in current window

        for (int i = minJump; i < n; i++) {
            // Add dp value for left bound of current window
            count += dp[i - minJump] ? 1 : 0;

            // Remove dp value for elements that are out of the window's range
            if (i - maxJump - 1 >= 0) {
                count -= dp[i - maxJump - 1] ? 1 : 0;
            }

            // Position i is reachable if there is any reachable position in window and s[i] == '0'
            dp[i] = count > 0 && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }
}
