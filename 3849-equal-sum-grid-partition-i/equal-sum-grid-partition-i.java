class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                total+= (long)grid[i][j];
            }
        }

        long rows = (long)0;

        for(int i = 0;i<n-1;i++){
            for(int j=0;j<m;j++){
                rows += (long)grid[i][j];
            }
            if(rows == (total - rows)) return true;
        }
        long cols = (long)0;
        for(int j=0;j<m-1;j++){
            for(int i=0;i<n;i++){
                cols += (long)grid[i][j];
            }
            if(cols == (total-cols)) return true;
        }
        return false;
    }
}