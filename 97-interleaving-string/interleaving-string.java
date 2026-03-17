class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n= s1.length();
        int m = s2.length();
        int len = s3.length();
        if(len != n+m) return false;
        boolean dp[][][] = new boolean[n+1][m+1][len+1];
        dp[0][0][0] = true;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=len;k++){
                    if(k == 0) continue;
                    boolean ans = false;
                    if(i>0 && s1.charAt(i-1) == s3.charAt(k-1)){
                        ans |= dp[i-1][j][k-1];
                    }
                    if(j>0 && s2.charAt(j-1) == s3.charAt(k-1)){
                        ans |= dp[i][j-1][k-1];
                    }
                    dp[i][j][k] = ans;
                    
                }
            }
        }
        return dp[n][m][len];
    }
}