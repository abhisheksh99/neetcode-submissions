class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];

        buy[0] = -prices[0];  // Buying on the first day
        sell[0] = 0;          // Cannot sell on the first day
        rest[0] = 0;          // No profit on the first day if we rest

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(rest[i-1], sell[i-1]);
        }

        return Math.max(sell[n-1], rest[n-1]); // Maximum profit on the last day, after all transactions
    }
}