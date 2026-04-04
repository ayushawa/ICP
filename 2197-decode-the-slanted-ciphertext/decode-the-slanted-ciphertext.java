class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols= n/rows;
        char grid[][] = new char[rows][cols];
        int ind = 0;
        for(int i=0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                grid[i][j] = encodedText.charAt(ind++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int k= 0;k<cols;k++){
            int i =0,j = k;
            
            while(i<rows && j<cols){
                if(grid[i][j]>='a' && grid[i][j]<='z') {
                    sb.append(grid[i][j]);
                }
                else sb.append(" ");
                i++;
                j++;
            }
        }
        return sb.toString().stripTrailing();

    }
}