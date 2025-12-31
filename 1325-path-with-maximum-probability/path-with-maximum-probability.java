class Pair{
    int node;
    double d ;
    Pair(int node,double d){
        this.d = d;
        this.node = node;
    }
}


class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }

         Queue<Pair> q =new LinkedList<>();

         double arr[] = new double[n];
        q.add(new Pair(start_node,1));
        double ans =0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            double d = p.d;
            for(Pair p2: adj.get(node)){
                int node2 = p2.node;
                double d2 = p2.d;
                if(node2 == end_node){
                    arr[node2] = Math.max(arr[node2],d2*d);
                }
                else if(d2*d>arr[node2]){
                    arr[node2] = d2*d;
                    q.add(new Pair(node2,d2*d));
                }
            }
        }
        return arr[end_node];
    }
}