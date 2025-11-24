class Solution {
   
    public int maxProfit(int[] arr) {
        int n  = arr.length;
        int dp[][][] = new int[n+1][3][2];

        for(int i=n-1;i>=0;i--){
            for(int j = 0;j<3;j++){
                for(int buy = 1;buy>=0;buy--){
                    if(buy == 0){
                        
                        if(j>0) dp[i][j][buy] =Math.max(-arr[i]+dp[i+1][j-1][1],dp[i+1][j][0]);
                        else dp[i][j][buy] = dp[i+1][j][0];
                    }
                    else {
                        dp[i][j][buy] = Math.max(arr[i] + dp[i+1][j][0], dp[i+1][j][1]);
                    }
                }
            }
        }
        return dp[0][2][0];
    }
}