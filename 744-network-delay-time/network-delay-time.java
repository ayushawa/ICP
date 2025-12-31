class Pair{
    int node,d;
    Pair(int node,int d){
        this.node = node;
        this.d = d;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.d-b.d);
        dist[k] = 0;
        q.add(new Pair(k,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int d = p.d;
            for(Pair p2 : adj.get(node)){
                int node2 = p2.node;
                int d2 = p2.d;
                if(dist[node2]>d+d2){
                    dist[node2] = d+d2;
                    q.add(new Pair(node2,d+d2));
                }
            }
        }
        int maxi = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi,dist[i]);
        }
        return maxi;
    }
}