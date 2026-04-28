class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer>  l = new ArrayList<>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                l.add(grid[i][j]);
            }
        }
        Collections.sort(l);
        int  n = l.size() ;
        int mid = 0;
        if(n%2 == 0){
            mid = n/2;
        } else {
            mid = n/2 ;
        }
        int target = l.get(mid);
        int count = 0;
        for(int i=0;i<n;i++){
            int rest = Math.abs(l.get(i) - target);
            if(rest % x !=0) return -1;
            else count += rest/x;
        }
        return count;

    }
}