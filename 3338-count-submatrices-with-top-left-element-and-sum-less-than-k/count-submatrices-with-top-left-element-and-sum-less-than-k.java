class Solution {
    public int CountSum(int arr[],int target){
        int count =0;
        int sum =0;
        for(int i :arr){
            sum += i;
            if(sum<=target) count++;
        }
        return count;
        
    }
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[m];
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[j]+= grid[i][j];
            }
            count+= CountSum(arr,k);
        }
        return count;
    }
}