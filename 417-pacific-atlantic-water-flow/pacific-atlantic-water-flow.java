class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m= heights[0].length;
        int pacific[][] = new int[n][m];
        Queue<int[]> q  = new LinkedList<>();
        for(int i = 0;i<m;i++){
            q.add(new int[]{-1,i});
        }
        for(int i = 0;i<n;i++){
            q.add(new int[]{i,-1});
        }
        int rows[] = {1,-1,0,0};
        int cols[] = {0,0,1,-1};

        while(!q.isEmpty()){
            int ar[] = q.poll();
            int r = ar[0];
            int c = ar[1];
            for(int k = 0;k<4;k++){
                int rl = r + rows[k];
                int cl = c + cols[k];
                if( rl<0 || cl<0 || rl>=n ||cl>= m){
                    continue;
                }
                else if((r == -1 || c == -1 ) && pacific[rl][cl] == 0){
                    pacific[rl][cl] =1;
                    q.add(new int[]{rl,cl});
                }
                else if(r>=0 && c>=0 && heights[r][c]<=heights[rl][cl] && pacific[rl][cl] == 0){
                    pacific[rl][cl] =1;
                    q.add(new int[]{rl,cl});
                }
            }
        }

        int atlantic[][]  = new int[n][m];
        for(int i = 0;i<n;i++){
            q.add(new int[]{i,m});
        }
        for(int i = 0 ;i<m;i++){
            q.add(new int[]{n,i});
        }

        while(!q.isEmpty()){
            int[] ar = q.poll();
            int r =ar[0];
            int c = ar[1];

            for(int k =0;k<4;k++){
                int rl = r + rows[k];
                int cl = c + cols[k];
                if(rl<0 || cl<0 || rl>=n || cl>=m) continue;
                else if((r == n || c == m ) && atlantic[rl][cl] == 0){
                    atlantic[rl][cl] = 1;
                    q.add(new int[]{rl,cl});
                }
                else if( r<n && c<m && heights[r][c] <=heights[rl][cl] && atlantic[rl][cl] == 0){
                    atlantic[rl][cl] = 1;
                    q.add(new int[]{rl,cl});
                }
            }
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}