class Pair{
    int val,x,y;
    Pair(int val,int x,int y){
        this.val = val;
        this.x = x;
        this.y  = y;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {  
        int n = grid.length;
        int m  = grid[0].length;
        int visited[][] = new int[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.val-b.val);
        pq.add(new Pair(grid[0][0],0,0));
        visited[0][0] = 1;
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int val = p.val;
            if(x == n-1 && y == m-1){
                return val;
            }
            for(int k=0;k<4;k++){
                int r = rows[k] + x;
                int c = cols[k] + y;
                if(r>=0 && c>=0 && r<n && c<m && visited[r][c]==0){
                    visited[r][c] = 1;
                    pq.add(new Pair(Math.max(val,grid[r][c]),r,c));
                }
            }
        }
        return -1;
    }
}