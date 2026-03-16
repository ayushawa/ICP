class Solution {
    int ans = 0;
    public int helper(char matrix[][],int i,int j,int dp[][]){
        if(i == matrix.length || j== matrix[0].length || matrix[i][j]=='0') {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int square =  Math.min(helper(matrix,i+1,j+1,dp),Math.min(helper(matrix,i+1,j,dp),helper(matrix,i,j+1,dp))) + 1;
        ans = Math.max(ans,square);
        return dp[i][j] = square;
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];  
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        } 
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
               if(matrix[i][j] == '1') ans = Math.max(ans,helper(matrix,i,j,dp));
            }
        }
        return ans * ans;
        
    }
}