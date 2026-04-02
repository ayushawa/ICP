class Solution {
    public long gridGame(int[][] grid) {
        long topsum = 0;
        int n = grid[0].length;
        for(int i=0;i<n;i++){
            topsum += grid[0][i];
        }
        long mini  = Long.MAX_VALUE;
        long bottomsum = 0;
        for(int i=0;i<n;i++){
            topsum -= grid[0][i];
            mini = Math.min(mini,Math.max(topsum,bottomsum));
            bottomsum += grid[1][i];
        }
        return mini;
    }
}