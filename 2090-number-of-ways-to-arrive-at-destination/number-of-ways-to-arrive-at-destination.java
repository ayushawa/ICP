class Pair{
    int node;
    long t;
    Pair(int node,long t ){
        this.node = node;
        this.t = t;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)((long)1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        int ways[] = new int[n];
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.t,b.t));
         pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair  p = pq.poll();
            int node = p.node;
            long t = p.t;
            for(Pair p2 : adj.get(node)){
                int neigh = p2.node;
                long w= p2.t;
                if(dist[neigh]>t + w){
                    dist[neigh] = t + w;
                    ways[neigh] = ways[node];
                    pq.add(new Pair(neigh,t+w));
                }
                else if(dist[neigh] == t+w){
                    ways[neigh]= (ways[node] + ways[neigh])%mod;
                }
                
            }
        }
        return ways[n-1];

    }
}