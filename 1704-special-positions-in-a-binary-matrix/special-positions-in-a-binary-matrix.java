class Solution {
    public boolean isSpecial(int mat[][],int i,int j){
        int n= mat.length;
        int m = mat[0].length;
        for(int k = 0;k<n;k++){
            if(k!=i && mat[k][j] == 1) return false;
        }
        for(int k = 0;k<m;k++){
            if(k!=j && mat[i][k] == 1) return false;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1 && isSpecial(mat,i,j)) count++;
            }
        }
        return count;
    }
}