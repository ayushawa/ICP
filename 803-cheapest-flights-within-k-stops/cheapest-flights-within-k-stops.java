class Pair{
    int nod,cost;
    Pair(int nod,int cost){
        this.nod = nod;
        this.cost = cost;
    }
}
class Touple{
    int val,c,d;
    Touple(int val,int c,int d){
        this.val = val;
        this.c = c;
        this.d = d;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Touple> pq =new LinkedList<>();
        dist[src] = 0;
        pq.add(new Touple(src,0,0));

        while(!pq.isEmpty()){
            Touple t = pq.poll();
            int c = t.c;
            int d = t.d;
            int val = t.val;
            if(c>k){
                System.out.println(c);
                 break;
            }
            for(Pair p : adj.get(val)){
                int nod = p.nod;
                int cost = p.cost;
                if(dist[nod]>d+cost){
                
                    dist[nod] = d + cost;
                    pq.add(new Touple(nod,c+1,d+cost));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}