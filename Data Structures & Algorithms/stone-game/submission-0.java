class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // Base cases: when the interval length is 1, dp[i][i] = piles[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Bottom-up calculation for intervals of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                // If player picks left pile
                int pickLeft = piles[i] - dp[i + 1][j];
                // If player picks right pile
                int pickRight = piles[j] - dp[i][j - 1];
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        // If the first player’s score difference is positive, they win
        return dp[0][n - 1] > 0;
    }
}
