class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int profit = 0;
        for(int i=0;i<n;i++){
            profit = Math.max(profit,prices[i]-mini);
            mini  = Math.min(prices[i],mini);
        }
        return profit;
    }
}