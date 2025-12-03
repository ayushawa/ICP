class Solution {
    public int helper(int arr[],int i,int j,int t[][]){
        if(i>j) return 0;
        if(t[i][j] != -1) return t[i][j];
        int maxi = 0;
        for(int k=i;k<=j;k++){
            maxi = Math.max(maxi,arr[i-1]*arr[k]*arr[j+1]+helper(arr,i,k-1,t)+helper(arr,k+1,j,t));
        }
        return t[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
      int n= nums.length;
      int arr[] = new int[n+2];
      arr[0] = 1;
      arr[n+1] = 1;
      for(int i=0;i<n;i++){
        arr[i+1] = nums[i];
      }   
      int t[][] = new int[n+2][n+2];
      for(int i=0;i<n+2;i++){
        Arrays.fill(t[i],-1);
      }

      return helper(arr,1,n,t);
    }
}