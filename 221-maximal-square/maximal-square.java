class Solution {
    public int helper(int arr[]){
        int n  = arr.length;
        int maxi = 0;
        for(int i=0;i<n;i++){
            int val =  arr[i];
            int j = i-1;
            int count= 1;
            while(j>=0 && arr[j]>=val){
                count++;
                if(count>=val) break;
                j--;
            }

            if(count<val){
               j  = i+1;
               while(j<n && arr[j]>=val){
                    count++;
                    if(count>=val) break;
                      j++;
                 }
            }
            if(count>=val) maxi = Math.max(maxi,val*val);
        }
        return maxi ;
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[m];
        int maxi = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j] += 1;
            }
            maxi = Math.max(maxi,helper(arr));
        }
        return maxi;
    }
}