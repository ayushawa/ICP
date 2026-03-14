class Solution {
    public int numSquares(int n) {
        List<Integer> l = new ArrayList<>();
        int num = 1;
        while(num*num<=n){
            l.add(num*num);
            num++;
        }
        int m = l.size();
        int dp[][] = new int[m][n+1];
         for(int i=0;i<=n;i++){
            dp[0][i] = i;
         }
         for(int i=1;i<m;i++){
            for(int j=0;j<=n;j++){
                int take = Integer.MAX_VALUE;
                if(j>=l.get(i)){
                    take = dp[i][j-l.get(i)];
                    if(take != Integer.MAX_VALUE) take++;
                }
                int nottake = dp[i-1][j];
                dp[i][j] = Math.min(take,nottake);
            }
         }
         return dp[m-1][n];

    }
}