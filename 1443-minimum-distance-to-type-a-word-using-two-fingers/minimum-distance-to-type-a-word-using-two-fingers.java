class Solution {
    public int dis(int a,int b){
        int x1 = a/6, y1=a%6;
        int x2 = b/6 ,y2 = b%6;
        return Math.abs(x2-x1) + Math.abs(y1-y2);
    }
    public int minimumDistance(String word) {
        int dp[] = new int[26];
        for(int i= 1;i<word.length();i++){
            int curr = word.charAt(i)-'A';
            int prev = word.charAt(i-1)-'A';

            int newdp[] = new int[26];
            Arrays.fill(newdp,Integer.MAX_VALUE);
            for(int j=0;j<26;j++){
                newdp[j] = Math.min(newdp[j],dp[j]+dis(prev,curr));
                newdp[prev] = Math.min(newdp[prev],dp[j]+dis(j,curr));
            }
            dp = newdp;
        }

        int mini = Integer.MAX_VALUE;
        for(int x: dp) mini = Math.min(mini,x);
        return mini;
    }
}