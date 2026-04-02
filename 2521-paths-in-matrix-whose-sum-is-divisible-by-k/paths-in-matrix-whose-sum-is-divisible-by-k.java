class Solution {
    static int mod = 1000000007;
    public int helper(int grid[][],int i,int j,int sum,int k,int dp[][][]){
        if(i == grid.length-1 && j== grid[0].length-1){
            if((grid[i][j]+ sum ) % k == 0){
                return 1;
            }
            else return 0;
        }
        if(dp[i][j][sum] != -1) return dp[i][j][sum];
        int left = 0;
        int right = 0;
        int sum2  = (sum + grid[i][j]) % k;
        if(j+1 < grid[0].length) left = helper(grid,i,j+1,sum2,k,dp);
        if(i+1 <grid.length) right = helper(grid,i+1,j,sum2,k,dp);
        return dp[i][j][sum] =  (left + right ) % mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(grid,0,0,0,k,dp);
    }
}