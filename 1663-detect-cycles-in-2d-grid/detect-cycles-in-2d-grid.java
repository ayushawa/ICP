class Solution {
    public boolean dfs(char grid[][],int i,int j,int lasti,int lastj,int visited[][]){
        visited[i][j] = 1;
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        for(int k = 0;k<4;k++){
            int r = i + rows[k];
            int c = j + cols[k];
            if(r>=0 && c>= 0 && r<grid.length && c<grid[0].length ){
                if(visited[r][c] == 1 && r != lasti && c != lastj  && grid[r][c] == grid[i][j]){
                    return true;
                }
                else if(visited[r][c] == 0 && grid[r][c] == grid[i][j] ){
                    if(dfs(grid,r,c,i,j,visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0){
                    if(dfs(grid,i,j,-1,-1,visited)) return true;
                }
            }
        } 
        return false;  
    }
}