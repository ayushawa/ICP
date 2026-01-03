class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int node,int group,int visited[]){
        visited[node]  = group;
        for(int neigh : adj.get(node)){
            if(visited[neigh] == 0){
                int group2 = group == 1? 2 : 1;
                if(dfs(adj,neigh,group2,visited)) return true;
            }
            else if(visited[neigh] == group) return true;
        }
        return false;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<dislikes.length;i++){
            adj.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            adj.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }

        int visited[] = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
               if( dfs(adj,i,1,visited)) return false;
            }
        }
        return true;
    }

}