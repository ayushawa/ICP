class Solution {
   
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[][][] = new int[n+1][3][2];
        for(int i=n-1;i>=0;i--){
            for(int t=1;t<=2;t++){
                for(int buy = 0;buy<2;buy++){
                    if(buy == 0){
                          int take = -arr[i] + dp[i+1][t][1] ;
                          int nottake = dp[i+1][t][buy];
                          dp[i][t][buy]= Math.max(take,nottake);
                    }
                    else {
                           int take = arr[i] + dp[i+1][t-1][0];
                           int nottake = dp[i+1][t][1];
                            dp[i][t][buy] =Math.max(take,nottake);
                    }
                }
            }
        }
        return dp[0][2][0];
    }
}