class Solution {
    public int helper(int dungeon[][],int i,int j,int dp[][]){
        if(i == dungeon.length-1 && j == dungeon[0].length-1){
            if(dungeon[i][j]>=0) return 1;
            else return Math.abs(dungeon[i][j]) + 1;
        }
        if(dp[i][j] !=-1) return dp[i][j];

        int down = Integer.MAX_VALUE,right = Integer.MAX_VALUE;
        if(i+1<dungeon.length) down = helper(dungeon,i+1,j,dp);
        if(j+1<dungeon[0].length) right = helper(dungeon,i,j+1,dp);
        int mini = Math.min(down,right);
        int result  = Integer.MAX_VALUE;
        if(mini != Integer.MAX_VALUE) {
            result = mini - dungeon[i][j];
            if(result <=0) result = 1;
        }
        return dp[i][j] =  result;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n= dungeon.length;
        int m = dungeon[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dungeon,0,0,dp);
    }
}