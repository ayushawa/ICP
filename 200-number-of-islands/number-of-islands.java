class Solution {
    public void dfs(char grid[][],int i,int j,int visited[][]){
        visited[i][j] = 1;
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        for(int k=0;k<4;k++){
            int rw = rows[k] + i;
            int cl = cols[k] + j;
            if(rw>=0 && cl>=0 && rw<grid.length && cl<grid[0].length && grid[rw][cl]=='1' && visited[rw][cl] == 0){
                dfs(grid,rw,cl,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int visited[][] = new int[n][m];
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}