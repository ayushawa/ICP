class Solution {
    public void dfs(List<List<Integer>> adj,int i,int visited[]){
        visited[i] = 1;
        for(int node: adj.get(i)){
            if(visited[node] == 0) dfs(adj,node,visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0;
        int n = isConnected.length;
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++ ){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 0) continue;
                else adj.get(i).add(j);
            }
        }

        int visited[] = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;
    }
}