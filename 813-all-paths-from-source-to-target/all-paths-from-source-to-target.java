class Solution {
    public  void dfs(int[][] graph,int i,int visited[],List<Integer> l,List<List<Integer>> ans ){
        
        if(i == visited.length-1){
            l.add(i);
            ans.add(new ArrayList(l));
            l.remove(l.size()-1);
            return ;
        }
        visited[i] = 1;
        l.add(i);
        for(int node: graph[i]){
            if(visited[node] == 0){
                dfs(graph,node,visited,l,ans);
            }
        }
        l.remove(l.size()-1);
        visited[i] = 0;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        int visited[] = new int[n];
        visited[0] = 1;
        
        dfs(graph,0,visited,new ArrayList<>(),ans);
        return ans;
    }
}