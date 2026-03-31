class Solution {
    public int helper(int grid[][],int i,int j,int dp[][]){
        if(i == grid.length-1){
            return grid[i][j];
        }
        if(dp[i][j] !=Integer.MAX_VALUE) return dp[i][j];

        int minVal = Integer.MAX_VALUE;
        for(int k =0;k<grid.length;k++){
            if(k!=j) minVal = Math.min(minVal,grid[i][j]+helper(grid,i+1,k,dp));
        }
        return dp[i][j] = minVal;
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int j =0;j<n;j++){
            ans = Math.min(ans,helper(grid,0,j,dp));
        }
        return ans;
    }
}