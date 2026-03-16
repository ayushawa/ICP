class Solution {
    public int helper(String s,int i,String t,int j,int dp[][]){
        if(j == 0) return 1;
        else if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(s.charAt(i-1) == t.charAt(j-1)) take = helper(s,i-1,t,j-1,dp);
        int nottake = helper(s,i-1,t,j,dp);
        return dp[i][j] = take + nottake;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take = 0;
                if(s.charAt(i-1) == t.charAt(j-1)) take = dp[i-1][j-1];
                int nottake = dp[i-1][j];
                dp[i][j] = take + nottake;
            }
        }
        
        return dp[n][m];   
    }
}