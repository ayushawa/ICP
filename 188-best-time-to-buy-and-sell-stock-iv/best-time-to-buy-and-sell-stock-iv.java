class Solution {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int prev[]  = new int[2*k+1];

        for(int i=n-1;i>=0;i--){
            int curr[] = new int[2*k+1];
            for(int j=2*k-1;j>=0;j--){
                if(j%2 == 0){
                    curr[j] = Math.max(-prices[i]+prev[j+1],prev[j]);
                }
                else {
                    curr[j] = Math.max(prices[i]+prev[j+1],prev[j]);
                }
            }
            prev = curr;
        }

        return prev[0];
        
    }
}