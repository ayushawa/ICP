class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m= word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=m;i++){
            dp[0][i] = i;
        }
        for(int j=1;j<=n;j++){
            dp[j][0] = j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int rep = 1 + dp[i-1][j-1];
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(rep,Math.min(insert,delete));
                }
            }
        }
        return dp[n][m];
    }
}