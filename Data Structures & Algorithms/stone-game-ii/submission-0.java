class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dfs(0, 1, piles, dp, suffixSum);
    }

    private int dfs(int i, int M, int[] piles, int[][] dp, int[] suffixSum) {
        int n = piles.length;
        if (i >= n) return 0;
        if (dp[i][M] != -1) return dp[i][M];

        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            if (i + x > n) break;
            int opponent = dfs(i + x, Math.max(M, x), piles, dp, suffixSum);
            int current = suffixSum[i] - opponent; // stones collected by current player
            maxStones = Math.max(maxStones, current);
        }

        dp[i][M] = maxStones;
        return maxStones;
    }
}
