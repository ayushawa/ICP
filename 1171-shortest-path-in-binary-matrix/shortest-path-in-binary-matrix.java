class Pair{
    int r,c,d;
    Pair(int d,int r,int c){
        this.r = r;
        this.d  = d;
        this.c = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n= grid.length;
        int visited[][] = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,0));
        int rows[] = {1,-1,0,0,1,-1,1,-1};
        int cols[] = {0,0,1,-1,1,-1,-1,1};
        visited[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c =  p.c;
            int d = p.d;
            if(r == n-1 && c == n-1){
                return d+1;
            }
            for(int k=0;k<8;k++){
                int rw = rows[k] + r;
                int cl = cols[k] + c;
                if(rw>=0 && cl>=0 && rw<n && cl<n && visited[rw][cl] == 0 && grid[rw][cl] == 0){
                    visited[rw][cl]=1;
                    q.add(new Pair(d+1,rw,cl));
                }
            }
        }
        return -1;
    }
}