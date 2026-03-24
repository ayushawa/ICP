class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long pref[] = new long[n *m];
        long suff[] = new long[n * m];
        long mod = 12345;
        pref[0] = ((long)grid[0][0])%mod;
        int ind = 1;
        for(int i  = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j== 0) continue;
                pref[ind] = (pref[ind-1] * ((long)grid[i][j]  )%mod)%mod;
                ind++;
            }
        }
        ind = n*m-1;
        suff[ind] = ((long)grid[n-1][m-1])%mod;
        ind--;
        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i ==n-1 && j== m-1) continue;
                suff[ind] = (suff[ind+1] * ((long)grid[i][j] )%mod)%mod;
                ind--;
            }
        }

        int ans[][] = new int[n][m];
        ind = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ind == 0 ) ans[i][j] = (int)suff[ind+1];
                else if(ind == n* m -1) ans[i][j] = (int)pref[ind-1];
                else ans[i][j] = (int)((pref[ind-1] * suff[ind+1])%mod);
                ind++;
            }
        }
        return ans;
    }
}