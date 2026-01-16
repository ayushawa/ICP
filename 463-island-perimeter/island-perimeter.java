class Solution {
    public int dfs(int grid[][],int i,int j,int visited[][],int res[]){
        visited[i][j] = 1;
        int para = 0;
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        for(int k=0;k<4;k++){
            int r = i + rows[k];
            int c = j + cols[k];
            if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) para++;
            else if(grid[r][c] == 0) para++;
            else if(visited[r][c] == 0 && grid[r][c] ==1) para+= dfs(grid,r,c,visited,res);
        }
        res[0]+= para;
        return para;
    }
    public int islandPerimeter(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int res[] = {0};
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return dfs(grid,i,j,visited,res);
                }
            }
        }
        return res[0];
    }
}