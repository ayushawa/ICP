class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

       int prefix[] = new int[n];
       prefix[0] = 0;
       for(int i=1;i<n;i++){
          if(nums[i]-nums[i-1]>maxDiff){
            prefix[i] = prefix[i-1]+1;
          }
          else prefix[i] = prefix[i-1];
       }

       boolean pathexist[] = new boolean[queries.length];
       for(int i=0;i<queries.length;i++){
          int u = queries[i][0];
          int v = queries[i][1];
          if(prefix[v]-prefix[u] == 0) pathexist[i] = true;
       }
       return pathexist;


    }
}