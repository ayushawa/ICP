class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;


        for(int i = 0;i<n;i++){
            int stones  = 0;
            for(int j = 0;j<m;j++){
                if(box[i][j] == '#') stones++;
                else if(box[i][j] == '*'){
                    int k = j-1;
                    while(k>=0 && box[i][k] != '*'){
                        if(stones > 0){
                            box[i][k] = '#';
                            stones--;
                        }
                        else box[i][k] = '.';
                        k--;
                    }
                    stones = 0;
                }
            }
            if(stones > 0){
                int k = m-1;
                 while(k>=0 && box[i][k] != '*'){
                        if(stones > 0){
                            box[i][k] = '#';
                            stones--;
                        }
                        else box[i][k] = '.';
                        k--;
                    }
            }
        }
        char ans[][] = new char[m][n];
    
        int col = 0;
        for(int i = n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                ans[j][col] = box[i][j];
            }
            col++;
        }
        return ans;
    }
}