class Solution {
    public int helper(int grid[][],int i,int j,int k,int val, int temp[][][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            val = (val + grid[i][j])%k;
            if(val == 0) return 1;
            return 0;
        }
         int mod = (int)1000000007;
        if(temp[i][j][val] !=-1) return temp[i][j][val];

        int down = helper(grid,i+1,j,k,(val+grid[i][j])%k,temp)%mod;
        int right = helper(grid,i,j+1,k,(val+grid[i][j])%k,temp)%mod;
        return temp[i][j][val] = ( down + right)%mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        // int dp[][][] = new int[n][m][k];
        // int v = grid[n-1][m-1];

        // int limit = v%k == 0? 0 : k - (v%k);
        // dp[n-1][m-1][limit] = 1;
        // int mod = (int)1000000007;
        // for(int i =n-2;i>=0;i--){
        //     for(int j=m-2;j>0;j--){
        //         for(int t = k-1;t>=0;t--){
        //             int down = dp[i+1][j][(t+grid[i][j])%k];
        //             int right = dp[i][j+1][(t+grid[i][j])%k];
        //             dp[i][j][t] = down + right;
        //         }
        //     }
        // }

        // return dp[0][0][0];
        int temp[][][] = new int[n][m][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(temp[i][j],-1);
            }
        }
        return helper(grid,0,0,k,0,temp);
        
    }
}