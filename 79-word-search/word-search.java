class Solution {
    public boolean isPresent(char board[][],int i,int j,String s,int k,int visited[][]){
        if(k == s.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] == 1|| board[i][j] != s.charAt(k)){
            return false;
        }
        boolean ans = false;
        visited[i][j] = 1;
        ans |= isPresent(board,i,j+1,s,k+1,visited);
        ans |= isPresent(board,i,j-1,s,k+1,visited);
        ans |= isPresent(board,i+1,j,s,k+1,visited);
        ans |= isPresent(board,i-1,j,s,k+1,visited);
        visited[i][j] = 0;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m  = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    int visited[][] = new int[n][m];
                    if(isPresent(board,i,j,word,0,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}