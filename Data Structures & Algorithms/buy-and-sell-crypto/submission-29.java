class Solution {
    public int maxProfit(int[] prices) {
        int left=0,right=0;
        int maxP=0;

        while(right<prices.length){
            if(prices[left]<prices[right]){
                int profit=prices[right]-prices[left];
                maxP=Math.max(profit,maxP);
            }else{
                left=right;
            }
            right++;

        }
        return maxP;
    }
}
