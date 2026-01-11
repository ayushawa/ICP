class Solution {
    public int findParent(int node,int parent[]){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node],parent);
    }

    public void unionByRank(int u,int v,int rank[],int parent[]){
        int parentu = findParent(u,parent);
        int parentv = findParent(v,parent);

        int ranku = rank[parentu];
        int rankv = rank[parentv];
        if(ranku>rankv){
            parent[parentv] = parentu;
        }
        else if(ranku<rankv){
            parent[parentu] = parentv;
        }
        else {
            parent[parentv] = parentu;
            rank[parentu]++;
        }
        
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n =0;
        for(int i=0;i<edges.length;i++){
            n = Math.max(edges[i][0],n);
            n = Math.max(edges[i][1],n);
        }
        n++;
        int ans[] = {-1,-1};
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int rank[] = new int[n];
        Arrays.fill(rank,1);

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(findParent(u,parent) == findParent(v,parent)){
                ans[0] = u;
                ans[1] =v;
            }
            else unionByRank(u,v,rank,parent);
        }
        return ans;
    }
}