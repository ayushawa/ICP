class Pair{
    int r,c;
    Pair(int r,int c){
        this.r = r;
        this.c = c;
    
    }
}
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         int visited[][] = new int[n][m];   
        Queue<Pair> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new Pair(0,0));
        int dir[][] = {
            {0,-1,0,1},
            {-1,0,1,0},
            {0,-1,1,0},
            {0,1,1,0},
            {0,-1,-1,0},
            {-1,0,0,1}
        };
        char chrs[][] = {
            {'l','r'},
            {'u','d'},
            {'l','d'},
            {'r','d'},
            {'l','u'},
            {'u','r'}
        };
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int val = grid[r][c];
            
            if(r == n-1 && c == m-1) break;
            for(int i = 0;i<4;i+=2){
                int rl = r + dir[val-1][i];
                int cl = c + dir[val-1][i+1];
                
                if(rl>=0 && cl>=0 && rl<n && cl<m && visited[rl][cl] == 0 ){
                    int val2 = grid[rl][cl];
                    int r1 = rl + dir[val2-1][0];
                    int c1 = cl + dir[val2-1][1];
                    int r2 = rl + dir[val2-1][2];
                    int c2 = cl + dir[val2-1][3];
                  
                    if((r1 == r && c1 == c) || (r2 == r && c2 == c)){
         
                        visited[rl][cl] = 1;
                       q.add(new Pair(rl,cl));
                    }
                    
                }
            }
        }

        return visited[n-1][m-1] == 1;
    }
}