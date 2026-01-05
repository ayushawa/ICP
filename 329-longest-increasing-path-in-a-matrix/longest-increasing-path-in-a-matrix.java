class Solution {
    public int helper(int matrix[][],int cr,int cc,int dp[][]){
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        if(dp[cr][cc]!= 0) return dp[cr][cc];
        int ans = 1;
        for(int k=0;k<4;k++){
            int rw = rows[k] + cr;
            int cl = cols[k] + cc;
            if(rw>=0 && rw<matrix.length && cl>=0 && cl<matrix[0].length && ( matrix[rw][cl]>matrix[cr][cc])){
                ans = Math.max(ans,1 + helper(matrix,rw,cl,dp));
            }
        }
        return dp[cr][cc] =  ans;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxi =0;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxi = Math.max(maxi,helper(matrix,i,j,dp));
            }
        }
        return maxi;
    }
}