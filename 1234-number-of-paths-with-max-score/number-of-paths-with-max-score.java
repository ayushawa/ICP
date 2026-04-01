class Solution {
    static int mod = 1000000007;
    // public int findCount(char grid[][],int i,int j,int target){
    //     if(i == 0 && j == 0){
    //         if(target == 0) return 1;
    //         else return 0;
    //     }
    //     int count = 0;
    //     int val = grid[i][j] !='S' ? grid[i][j] - '0' : 0;
    //     if(target-val >=0){
    //         if(i-1>=0 && grid[i-1][j] !='X') count = findCount(grid,i-1,j,target-val);
    //         if(j-1>=0 && grid[i][j-1] !='X') count =( count + findCount(grid,i,j-1,target-val))%mod;
    //         if(i-1>=0 && j-1>=0 && grid[i][j] !='X') count = (count + findCount(grid,i-1,j-1,target-val)) % mod;
    //     }
    //     return count;
    // }
    // public int findMaxSum(char grid[][],int i,int j){
    //     if(i == 0 && j == 0) return 0;
    //     char temp  = grid[i][j];
    //     int val = temp!= 'S' ? temp-'0' : 0;
    //     grid[i][j] = 'X';
    //     int ans = Integer.MIN_VALUE;
    //     if(i-1 >=0 && grid[i-1][j] != 'X') ans = findMaxSum(grid,i-1,j);
    //     if(j-1 >=0 && grid[i][j-1] !='X') ans =Math.max(ans,findMaxSum(grid,i,j-1));
    //     if(i-1>=0 && j-1>=0 && grid[i-1][j-1] !='X') ans = Math.max(ans,findMaxSum(grid,i-1,j-1));
    //     if(ans !=Integer.MIN_VALUE) ans+=val;
        
    //     grid[i][j] = temp;
    //     return ans;
    // }
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m= board.get(0).length();
        char grid[][] = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = board.get(i).charAt(j);
            }
        }

        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j== 0) continue;
                char temp = grid[i][j];
                int val = temp!='S' ? temp-'0' : 0;
                int ans = Integer.MIN_VALUE;
                if(i-1 >=0 && grid[i-1][j] !='X') ans=  dp[i-1][j];
                if(j-1 >=0 && grid[i][j-1] !='X') ans = Math.max(ans, dp[i][j-1]);
                if(i-1 >=0 && j-1>=0 && grid[i-1][j-1] !='X') ans = Math.max(ans,dp[i-1][j-1]);
                if(ans !=  Integer.MIN_VALUE) ans+=val;
                dp[i][j] = ans;
            }
        }

        if(dp[n-1][m-1] == Integer.MIN_VALUE) return new int[]{0,0};


        int maxSum = dp[n-1][m-1] ;
        

        int t[][][] = new int[n][m][maxSum+1];
        t[0][0][0] = 1;
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(i ==  0 && j == 0) continue;
                for(int k = 0;k<=maxSum;k++){
                    int count = 0;
                     int val = grid[i][j] !='S' ? grid[i][j] - '0' : 0;
                     if(k>=val){
                        if(i-1 >=0 && grid[i-1][j] !='X') count = t[i-1][j][k-val];
                        if(j-1>=0 && grid[i][j-1] !='X') count = (count + t[i][j-1][k-val])%mod;
                        if(i-1>=0 && j-1>=0 && grid[i-1][j-1] !='X') count = (count + t[i-1][j-1][k-val])%mod;

                     }
                     t[i][j][k] = count;
                }
            }
        }
        int count = t[n-1][m-1][maxSum];
        int ans[] = {maxSum,count};
        return ans;
    }
}