class Solution {
    public int maxProfit(int[] prices) {
        int maxi = prices[0];
        int mini = prices[0];
        int diff = 0;
        for(int x: prices){
            if(x<mini){
                mini = x;
                maxi = x;
            }
            else if(x>maxi) {
                maxi = x;
            }
            diff = Math.max(diff,maxi-mini);
        }
        return diff;
    }
}