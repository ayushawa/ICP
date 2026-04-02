class Solution {
    static class Pair{
        int r,c,count;
        Pair(int r,int c,int count){
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.count-b.count);
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;
        int rows[] = {0,0,0,1,-1};
        int cols[] = {0,1,-1,0,0};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r = p.r,c = p.c,count = p.count;
            if(dist[r][c]< count) continue;
            for(int k = 1;k<=4;k++){
                int rw = r + rows[k];
                int cl = c + cols[k];
                if(rw<0 || cl<0 || rw>=n || cl>=m) continue;
                if(k == grid[r][c]){
                    if(dist[rw][cl]>count){
                        dist[rw][cl] = count;
                        pq.add(new Pair(rw,cl,count));
                    }
                }
                else {
                    if(dist[rw][cl] > count + 1){
                        dist[rw][cl] = count + 1;
                        pq.add(new Pair(rw,cl,count + 1));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}