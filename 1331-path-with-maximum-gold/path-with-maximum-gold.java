class Solution {
    public int helper(int grid[][],int i,int j,int visited[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] == 1|| grid[i][j]==0 ){
            return 0;
        }
        int maxi = 0;
        int rows[] ={1,-1,0,0};
        int cols[] = {0,0,1,-1};
        visited[i][j] = 1;
        for(int k=0;k<4;k++){
            maxi = Math.max(maxi,grid[i][j]+helper(grid,i+rows[k],j+cols[k],visited));
        }

        visited[i][j] = 0;
        return maxi;
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxi = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0){
                    int visited[][] = new int[n][m];
                    maxi = Math.max(maxi,helper(grid,i,j,visited));
                }
            }
        }
        return maxi;
    }
}