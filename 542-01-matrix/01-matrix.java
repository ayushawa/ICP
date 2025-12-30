class Pair{
    int r,c;
    Pair(int r,int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dist[][] = new int[n][m];
        int visited[][] = new int[n][m];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                }
            }
        }
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r= p.r;
            int c = p.c;
            for(int k=0;k<4;k++){
                int rw = r + rows[k];
                int cl = c + cols[k];
                if(rw>=0 && cl>=0 && rw<n && cl<m && visited[rw][cl]==0 && mat[rw][cl]==1){
                    dist[rw][cl]= dist[r][c]+1;
                    visited[rw][cl] = 1;
                    q.add(new Pair(rw,cl));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1 && dist[i][j]==0) dist[i][j] = -1;
            }
        }
        return dist;
    }
}