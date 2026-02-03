class Solution {
    public int helper(int mat[][],int i,int sum ,int target,int dp[][]){
        if(i == mat.length-1){
            int diff = Integer.MAX_VALUE;
            for(int j=0;j<mat[i].length;j++){
                diff = Math.min(diff,Math.abs(target-(sum+mat[i][j])));
            }
            return diff ;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int diff = Integer.MAX_VALUE;
        for(int j = 0;j<mat[i].length;j++){
            diff = Math.min(diff,helper(mat,i+1,sum+mat[i][j],target,dp));
        }
        return dp[i][sum] =  diff;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int dp[][] = new int[mat.length][70 * 70 + 1];
        for(int i=0;i<mat.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(mat,0,0,target,dp);
    }
}