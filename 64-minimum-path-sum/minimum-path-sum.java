
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for(int i=n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(i == n-1 && j== m-1) continue;
                int right = Integer.MAX_VALUE;
                if(j+1<m ) {
                    right = dp[i][j+1];
                    if(right != Integer.MAX_VALUE) right += grid[i][j];
                }
                int left  = Integer.MAX_VALUE;
                if(i+1<n){
                    left = dp[i+1][j];
                    if(left != Integer.MAX_VALUE) left += grid[i][j];
                }
                dp[i][j] = Math.min(left,right);
            }
        }
        return dp[0][0];
        
    }
}