class Solution {
    public int dfs( List<List<Integer>> adj,int node,int timer,int parent,int disc[],int low[], List<List<Integer>> ans){
        if(disc[node] !=-1) return disc[node];
        timer++;
        disc[node] = timer;
        low[node] = timer;
        for(int neigh: adj.get(node)){
            if(neigh == parent) continue;

            low[node] = Math.min(low[node],dfs(adj,neigh,timer,node,disc,low,ans));

            if(low[neigh]>disc[node]){
                List<Integer> l = Arrays.asList(neigh,node);
                ans.add(new ArrayList<>(l));
            }
        }
        return low[node];
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> ans =new ArrayList<>();
        int disc[] = new int[n];
        Arrays.fill(disc,-1);
        int low[] = new int[n];
        Arrays.fill(low,-1);
        int timer = -1;
        int parent = -1;
        dfs(adj,0,timer,parent,disc,low,ans);
        return ans;
               
    }
}