class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int ans[][] = new int[n][n];
        int top = 0;
        int left =0;
        int right = n-1;
        int down = n-1;
        while(top<=down && left<=right){
            for(int i=left;i<=right;i++ ){
                ans[top][i] = num ;
                num++;
            }
            top++;
            for(int i=top;i<=down;i++){
                ans[i][right] =  num;
                num++;
            }
            right--;

            if(top<=down){
                for(int i=right;i>=left;i--){
                    ans[down][i] = num;
                    num++;
                }
                down--;
            }
            
            if(left<=right){
                for(int i=down;i>=top;i--){
                    ans[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return ans;
    }
}