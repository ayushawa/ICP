class Solution {
    public int helper(String s,int i ,int last,int dp[][]){
        if(i == s.length()+1) {
            return 0;
        }
        if(dp[i][last]!=-1) return dp[i][last];
        if(last == 0 ){
            if(s.charAt(i-1)=='a'){
                return dp[i][last] =  helper(s,i+1,0,dp);
            }
            else return dp[i][last]  =  Math.min(helper(s,i+1,1,dp),1+helper(s,i+1,0,dp));
        }
        else {
            if(s.charAt(i-1) == 'b') return dp[i][last] =  helper(s,i+1,1,dp);
            else return dp[i][last] =  1 + helper(s,i+1,1,dp);
        }
    }
    public int minimumDeletions(String s) {
        int n= s.length();
        int dp[][] = new int[n+1][2];
        for(int i=0;i<n+1;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return helper(s,1,0,dp);
    }
}