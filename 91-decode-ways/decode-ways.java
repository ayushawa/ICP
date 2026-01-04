class Solution {
    public int helper(String s,int i,int dp[]){
        
        if( i == s.length()){
            return 1;
        }
        if(dp[i]!=-1) return dp[i];
        int skip_one  = 0;
        if(s.charAt(i)!='0'  )skip_one = helper(s,i+1,dp);
        int skip_two  = 0;
        if(i!=s.length()-1 && s.charAt(i)!='0' &&  s.substring(i,i+2).compareTo("26")<=0){
            skip_two = helper(s,i+2,dp);
        }
        return dp[i] =  skip_one + skip_two;
    }
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return  helper(s,0,dp);
    }
}