class Solution {
    public int helper(int grid[][],int i1,int j1,int j2,int dp[][][]){
        if(i1 == grid.length-1 && j1 == grid.length-1){
            return grid[i1][j1];
        }
        if(dp[i1][j1][j2] !=Integer.MAX_VALUE ) return dp[i1][j1][j2];
        int ans = Integer.MIN_VALUE;
        int i2 = i1 + j1 - j2;
        int val = grid[i1][j1];
        if(i1 != i2 && j1 != j2) val += grid[i2][j2];
        if(i1 + 1 <grid.length && i2 + 1 <grid.length && grid[i1+1][j1] != -1 && grid[i2+1][j2] != -1) ans = Math.max(ans,helper(grid,i1+1,j1,j2,dp));
        if(i1 + 1 <grid.length && j2+1<grid.length && grid[i1+1][j1]!=-1 && grid[i2][j2+1] != -1) ans = Math.max(ans,helper(grid,i1+1,j1,j2+1,dp));

        if(j1 + 1<grid.length && i2+1 <grid.length && grid[i1][j1+1] !=-1  && grid[i2+1][j2] !=-1) ans  = Math.max(ans,helper(grid,i1,j1+1,j2,dp));

        if(j1 + 1<grid.length && j2+1<grid.length && grid[i1][j1+1] != -1 && grid[i2][j2+1] != -1) ans = Math.max(ans,helper(grid,i1,j1+1,j2+1,dp));

        if(ans != Integer.MIN_VALUE) ans+=val;
        return dp[i1][j1][j2] =  ans;

    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][] = new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        int ans =  helper(grid,0,0,0,dp) ;
       
        return ans != Integer.MIN_VALUE ? ans : 0;
    }
}