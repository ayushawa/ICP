class Solution {
    public int helper(int grid[][],int i,int j,int cost,int k,int dp[][][]){
        if(i == grid.length -1 && j == grid[0].length -1 ){
            int add = grid[i][j] == 0 ? 0 : 1;
            if(cost + add <= k) return dp[i][j][cost] =  grid[i][j];
            else return dp[i][j][cost] =  Integer.MIN_VALUE; 
        }
        if(dp[i][j][cost] != -1) return dp[i][j][cost];

        int add = grid[i][j] == 0 ? 0 : 1;

        int bottom  = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(i + 1 < grid.length && cost + add <= k ){
            bottom = helper(grid,i+1,j,cost + add ,k,dp);
            if(bottom != Integer.MIN_VALUE) bottom += grid[i][j];
        }
        if(j + 1 < grid[0].length && cost + add <= k){
            right = helper(grid,i,j+1,cost + add, k,dp);
            if(right != Integer.MIN_VALUE) right += grid[i][j];
        }
        return dp[i][j][cost]  =  Math.max(right,bottom);
    }
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m  = grid[0].length;
        int dp[][][] = new int[n][m][k+1];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = helper(grid,0,0,0,k,dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}