class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[n][m];
        for(int i=0;i<m;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) +  Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}