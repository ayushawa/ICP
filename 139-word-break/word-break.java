class Solution {
    public boolean helper(String s,int i,List<String> l,int dp[]){
        if(i == s.length()){
            return true;
        }
        if(dp[i] != -1) return dp[i] == 1 ? true : false;
        boolean ans = false;
        for(String str: l){
            int len = str.length();
            if(i+len-1<s.length() && str.equals(s.substring(i,i+len))){
                ans |= helper(s,i+len,l,dp);
            }
        }
        dp[i] = ans ? 1 : 0;
        return  ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(s,0,wordDict,dp);
    }
}