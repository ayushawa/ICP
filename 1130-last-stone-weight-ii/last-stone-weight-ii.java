class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum =0;
        for(int x: stones) sum += x;
        int n = stones.length;
        boolean dp[][] = new boolean[n][sum+1];
        dp[0][0] = true;
        dp[0][stones[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum;j++){
                
                if(j>= stones[i]) dp[i][j] = dp[i-1][j-stones[i]];
                dp[i][j] |= dp[i-1][j];
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i]){
                
                mini = Math.min(mini,Math.abs(i - (sum-i)));
            }
            
        }
        return mini;
    }
}