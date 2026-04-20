class Pair{
    int r,c,d,color;
    Pair(int r,int c,int d,int color){
        this.r = r;
        this.c = c;
        this.d = d;
        this.color = color;
    }
}
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.d == b.d ? b.color-a.color : a.d-b.d);
        int dist[][] = new int[n][m];
        for(int i =0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int ans[][] = new int[n][m];
        for(int i =0;i<sources.length;i++){
            int r = sources[i][0];
            int c = sources[i][1];
            int val = sources[i][2];
            ans[r][c] = val;
            dist[r][c]  = 0;
            q.add(new Pair(r,c,0,val));
        }


        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int d = p.d;
            int color = p.color;
            if(dist[r][c] < d) continue;
            for(int k=0;k<4;k++){
                int rw = r + rows[k];
                int cl = c + cols[k]; 
                if(rw<0 || cl<0 || rw>=n || cl>=m ) continue;
                if(d + 1 < dist[rw][cl]){
                    dist[rw][cl] = d + 1;
                    ans[rw][cl] = color;
                    q.add(new Pair(rw,cl,d+1,color));
                }
            }
        }
        return ans;
    }
}