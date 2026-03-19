class Solution {
    public int findSubmatrix(int pref[],boolean ones[]){
        int count = 0;
        int sum =0;
        boolean last = false;
        for(int i=0;i<pref.length;i++){
            last |= ones[i];
            sum += pref[i];
            if(sum == 0 && last) count++;
        }
        return count;
    }
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pref[] = new int[m];
        int count =0;
        boolean ones[] = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j] == 'X') ones[j] = true;
                if(grid[i][j] == 'X') pref[j]++;
                else if(grid[i][j] == 'Y') pref[j]--;
            }
             count += findSubmatrix(pref,ones);
        }
        return count;
        
    }
}