class Touple{
    int node,time,lost;
    Touple(int node,int time,int lost){
        this.node = node;
        this.time = time;
        this.lost = lost;
    }
}
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
        List<List<Touple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Touple(edges[i][1],edges[i][2],disappear[edges[i][1]]));
            adj.get(edges[i][1]).add(new Touple(edges[i][0],edges[i][2],disappear[edges[i][0]]));
        }
        int times[] = new int[n];
        Arrays.fill(times,Integer.MAX_VALUE);
        
        PriorityQueue<Pair> q =new PriorityQueue<>((a,b)->a.t-b.t);
        q.add(new Pair(0,0));
        times[0] = 0;
        while(!q.isEmpty()){
            Pair  p = q.poll();
            int node = p.node;
            int t= p.t;
            if (t > times[node]) continue;
            for(Touple top: adj.get(node)){
                int node2 = top.node;
                int time = top.time;
                int lostTime = top.lost;

                int totaltime = time + t;
                if(times[node2]>totaltime && totaltime<lostTime){
                    times[node2] = totaltime;
                    q.add(new Pair(node2,totaltime));
                }
            }
        }

   
        for(int i=0;i<n;i++){
            if(times[i] == Integer.MAX_VALUE) times[i] = -1;
           
        }
        return times;
    }
}