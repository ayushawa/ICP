class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int i=0;i<edges.length;i++){
            indegree[edges[i][1]]++;
        }
        int idx = -1;
        for(int i=0;i<n;i++){
            if(indegree[i] == 0 && idx == -1){
                idx = i;
            }
            else if(indegree[i] == 0 ){
                return -1;
            }
        }
        return idx;
    }
}