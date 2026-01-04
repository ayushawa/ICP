class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            int skip_one = 0;
            if(s.charAt(i)!='0') skip_one = dp[i+1];
            int skip_two = 0;
            if(i!=s.length()-1 && s.charAt(i)!='0' &&  s.substring(i,i+2).compareTo("26")<=0){
                 skip_two = dp[i+2];
             }
             dp[i] = skip_one + skip_two;

        }
        
        return  dp[0];
    }
}