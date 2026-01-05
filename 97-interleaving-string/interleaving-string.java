class Solution {
    public boolean helper(String s1,String s2,String s3,int i,int j,int k,int dp[][]){
        if(k==s3.length()){
           if(i == s1.length() && j == s2.length()) return true;
           return false;
        }
        if(dp[i][j] != -1 && dp[i][j] == 1) return true;
        else if(dp[i][j]!=-1) return false; 
        if(i==s1.length()){
            if(s2.charAt(j) == s3.charAt(k)) {
                boolean ans  = helper(s1,s2,s3,i,j+1,k+1,dp);
                if(ans == true) dp[i][j] = 1;
                else dp[i][j] = 0;
               return ans;
            }
            else {
                dp[i][j] = 0;
                return false;
            }
        }
        else if(j==s2.length()){
            if(s1.charAt(i) == s3.charAt(k)) {
                boolean ans =   helper(s1,s2,s3,i+1,j,k+1,dp);
                if(ans == true) dp[i][j] = 1;
                else dp[i][j] = 0;
              return ans;
            }
            else{
                dp[i][j] = 0;
                 return false;
            }
        }
        else if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            boolean ans = helper(s1,s2,s3,i+1,j,k+1,dp) || helper(s1,s2,s3,i,j+1,k+1,dp);
            if(ans == true) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        }
        else if(s1.charAt(i) == s3.charAt(k)){
            boolean ans =  helper(s1,s2,s3,i+1,j,k+1,dp);
            if(ans == true) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        }
        else if(s2.charAt(j) == s3.charAt(k)){
            boolean ans = helper(s1,s2,s3,i,j+1,k+1,dp);
            if(ans == true) dp[i][j] = 1;
             else dp[i][j] = 0;
            return ans;
        }
        dp[i][j] = 0;
       return false;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n= s1.length();
        int m=  s2.length();
        int len = s3.length();
        // if(Math.abs(n-m)>1) return false;
        if(n+m>len || len> n+m) return false;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s1,s2,s3,0,0,0,dp);
    }
}