class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int  n = matrix.length;
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int below = dp[i+1][j];
                int left = Integer.MAX_VALUE;
                if(j-1>=0) left = dp[i+1][j-1];
                int right = Integer.MAX_VALUE;
                if(j+1<n) right = dp[i+1][j+1];
                dp[i][j]  = matrix[i][j] + Math.min(below,Math.min(left,right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) ans = Math.min(ans,dp[0][i]);
        return ans;
    }
}