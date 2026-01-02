class Solution {
    public boolean dfs(List<List<Integer>> adj,int i,int visited[],int parent[]){
        visited[i] = 1;
        parent[i] = 1;
        for(int node : adj.get(i)){
            if(visited[node] == 0){
                if(dfs(adj,node,visited,parent)) return true;
            }
            else if(parent[node] == 1) return true;
        }
        parent[i] = 0;
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int visited[] = new int[V];
        int parent[] =new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i] == 0){
                
                if(dfs(adj,i,visited,parent)) return false;
            }
        }
        return true;
    }
}