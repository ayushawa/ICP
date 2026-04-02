class Solution {
    public int helper(int coins[][],int i,int j,int ability,int dp[][][]){
        if(i == coins.length-1 && j == coins[0].length-1){
            if(coins[i][j]>=0) return coins[i][j];
            else if(ability>0) return 0;
            else return coins[i][j];
        }
        if(dp[i][j][ability] != Integer.MAX_VALUE) return dp[i][j][ability];

        int right = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        if(ability>0 && coins[i][j]<0){
            if(i+1<coins.length) right = Math.max(coins[i][j] + helper(coins,i+1,j,ability,dp),helper(coins,i+1,j,ability-1,dp));
            if(j+1<coins[0].length) down = Math.max(coins[i][j] + helper(coins,i,j+1,ability,dp),helper(coins,i,j+1,ability-1,dp));
            return dp[i][j][ability] = Math.max(down,right);
        }
        else {
            if(j+1<coins[0].length ) right = helper(coins,i,j+1,ability,dp);
            if(i+1<coins.length) down = helper(coins,i+1,j,ability,dp);
            return dp[i][j][ability] =  coins[i][j] + Math.max(right,down);
        }

    }
    public int maximumAmount(int[][] coins) {
        int n= coins.length;
        int m = coins[0].length;
        int dp[][][] = new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        return helper(coins,0,0,2,dp);
    }
}