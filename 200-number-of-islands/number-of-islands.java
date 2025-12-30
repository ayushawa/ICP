class Solution {
    public void dfs(char grid[][],int i,int j,int visited[][]){
        visited[i][j] = 1;
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        for(int k=0;k<4;k++){
            int r = rows[k]+i;
            int c = cols[k] + j;
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && visited[r][c] == 0 && grid[r][c]=='1') dfs(grid,r,c,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int visited[][] = new int[n][grid[0].length];
        int count =0;
        for(int i =0;i<n;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == 0 && grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}