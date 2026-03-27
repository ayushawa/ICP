class Solution {
    public void shiftLeft(int copy[][],int i){
        int m = copy[0].length;
        int val = copy[i][0];
        for(int j = 0;j<m-1;j++){
            copy[i][j] = copy[i][j+1];
        }
        copy[i][m-1] = val;
    }
    public void shiftRight(int copy[][],int i){
        int m = copy[0].length;
        int val = copy[i][m-1];
        for(int j = m-1;j>=1;j--){
            copy[i][j] = copy[i][j-1];
        }
        copy[i][0] = val;
    }
    public boolean areSimilar(int[][] mat, int k) {
        int n= mat.length;
        int m = mat[0].length;
        int copy[][] = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j] = mat[i][j];
            }
        }   

        k = k % m;
        while(k-- >0){
            for(int i = 0;i<n;i++){
                if(i% 2 == 0) shiftLeft(copy,i);
                else shiftRight(copy,i);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j] != mat[i][j]) return false;
            }
        }
        return true;
    }
}