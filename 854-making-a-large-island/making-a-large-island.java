class DisjointSet{
    int parent[];
    int size[];

    DisjointSet(int node){
        parent = new int[node];
        size = new int[node];
        Arrays.fill(size,1);
        for(int i=0;i<node;i++){
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node,int parent[]){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findUltimateParent(parent[node],parent);
        return parent[node];
    }

    public void unionBySize(int node1,int node2){
        int ultimateParent1 = findUltimateParent(node1,parent);
        int ultimateParent2 = findUltimateParent(node2,parent);

        if(ultimateParent1 == ultimateParent2) return;

        int sum1 = size[ultimateParent1];
        int sum2 = size[ultimateParent2];

        if(sum1>sum2){
            parent[ultimateParent2] = ultimateParent1;
            size[ultimateParent1]+= sum2;
        }
        else if(sum1 < sum2){
            parent[ultimateParent1] = ultimateParent2;
             size[ultimateParent2]+= sum1;
        }
        else {
            parent[ultimateParent2] = ultimateParent1;
             size[ultimateParent1]+= sum2;
        }
    }
    
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        int node = n*m;
        DisjointSet dsu =new DisjointSet(node);

         int visited[][] = new int[n][m];

        int rows[] =  {0,0,1,-1};
        int cols[]  = {1,-1,0,0};
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0) continue;
                for(int k=0;k<4;k++){
                    int rl = rows[k] + i;
                    int cl = cols[k] + j;
                    int node1 = m * i + j;
                    if(rl>=0 && cl>=0 && rl<n && cl<m && grid[rl][cl] == 1){
                        int node2 = m * rl + cl;
                        dsu.unionBySize(node1,node2);
                    }
                }
            }
         }

         int ans =0;
        
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                     Set<Integer> set =new HashSet<>();
                    for(int k=0;k<4;k++){
                        int rl = rows[k] + i;
                        int cl = cols[k] + j;
                        if(rl<n && cl<m && rl>=0 && cl>=0 && grid[rl][cl] == 1){
                            int node2 = m * rl + cl;
                    
                            set.add(dsu.findUltimateParent(node2,dsu.parent));
                        }
                        
                    }
                    int total = 1;
                    for(int x: set) total += dsu.size[x];
                    ans = Math.max(total,ans);
                }
                

            }
         }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int nod = i * m + j;
                int count = dsu.size[dsu.findUltimateParent(nod,dsu.parent)];
                ans = Math.max(count,ans);
            }
         }
         return ans;
    }
}