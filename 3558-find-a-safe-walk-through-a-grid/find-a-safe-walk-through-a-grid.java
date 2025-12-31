class Pair{
    int r,c;
    Pair(int r,int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int dist[][] = new int[n][m];
        Queue<Pair> q =new LinkedList<>();
        if(grid.get(0).get(0) == 1) dist[0][0] = health-1;
        else dist[0][0] = health;
        q.add(new Pair(0,0));
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int d= dist[r][c];
            for(int k=0;k<4;k++){
                int rw = r + rows[k];
                int cl = c + cols[k];
                if(rw>=0 && cl>=0 && rw<n && cl<m ){
                    int d2 = dist[rw][cl];
                    if(grid.get(rw).get(cl) == 1 && d-1>0){
                        if(d2<d-1){
                            dist[rw][cl] = d-1;
                            q.add(new Pair(rw,cl));
                        }
                    }
                    else if(grid.get(rw).get(cl) == 0){
                        if(d2<d){
                            dist[rw][cl] = d;
                            q.add(new Pair(rw,cl));
                        }
                    }
                }
            }
        }
        if(dist[n-1][m-1] >0) return true;
        return false;
    }
}