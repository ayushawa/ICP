class Solution {
    public boolean isPath(ArrayList<ArrayList<Integer>> adj,int i,int dest,int visited[]){
        if(i == dest) return true;
        visited[i] = 1;
        boolean ans = false;
        for(int neigh: adj.get(i)){
            if(visited[neigh] == 0) {
                ans = ans | isPath(adj,neigh,dest,visited);
                if(ans == true) return true;
            }
        }
        return ans;
    }
    public List<Boolean> checkIfPrerequisite(int n , int[][] edges, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        List<Boolean> l =new ArrayList<>();

        for(int i =0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            int visited[] = new int[n];
            if(isPath(adj,u,v,visited)) l.add(true);
            else l.add(false);
        }
        return l;
        
    }
}