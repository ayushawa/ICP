class Pair{
    int node;
    int t;
    Pair(int node,int t){
        this.node = node;
        this.t = t;
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.t-b.t);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int t = p.t;
            if(dist[node]<t) continue;

            for(Pair p2 : adj.get(node)){
                int neigh = p2.node;
                int t2  = p2.t;
                if(dist[neigh]>t+t2 && t+t2<disappear[neigh]){
                    dist[neigh] = t+t2;
                    pq.add(new Pair(neigh,t+t2));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}