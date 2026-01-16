class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();
        int dp[][] = new int[n+1][m+1];
        int total = 0;
        for(int i=0;i<n;i++){
            int ascii  = (int)s1.charAt(i);
            total+= ascii;
        }
        for(int i=0;i<m;i++){
            int ascii = (int)s2.charAt(i);
            total+= ascii;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    int ascii = s1.charAt(i-1);
                    dp[i][j] =  ascii+ dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return total - 2 * dp[n][m];


    }
}