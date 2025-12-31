class Solution {
    public boolean dfs(List<List<Integer>> adj,int i,int visited[],int dest){
        visited[i] = 1;
        if(i == dest) return true;
        for(int node : adj.get(i)){
            if(visited[node] == 0){
                if(dfs(adj,node,visited,dest) == true) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int visited[] = new int[n];
        return dfs(adj,source,visited,destination);
    }
}