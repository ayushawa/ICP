class Solution {
 public int maxProfit(int[] prices) {
        int n= prices.length;
        int prev[][] = new int[3][2];

        for(int i=n-1;i>=0;i--){
            int curr[][] = new int[3][2];
            for(int k=1;k<=2;k++){
                for(int buy = 1;buy>=0;buy--){
                    if(buy == 0){
                        curr[k][buy] =Math.max(-prices[i] + prev[k][1],prev[k][0]);
                    }
                    else {
                        curr[k][buy] = Math.max(prices[i]+prev[k-1][0],prev[k][1]);
                    }
                }
            }
            prev = curr;
        }
        return prev[2][0];
    }
}