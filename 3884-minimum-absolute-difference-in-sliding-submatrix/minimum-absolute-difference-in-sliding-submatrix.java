class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n-k+1][m-k+1];
        for(int i = 0;i<n-k+1;i++){
            for(int j=0;j<m-k+1;j++){

                List<Integer> l = new ArrayList<>();
                for(int x = i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        l.add(grid[x][y]);
                    }

                }

                Collections.sort(l);
                int mini = Integer.MAX_VALUE;
                for(int x=1;x<l.size();x++){
                    if(l.get(x).equals(l.get(x-1))) continue;
                    mini = Math.min(l.get(x)-l.get(x-1),mini);
                }
                ans[i][j] = mini == Integer.MAX_VALUE ? 0 : mini;
            }
        }
        return ans;
        
    }
}