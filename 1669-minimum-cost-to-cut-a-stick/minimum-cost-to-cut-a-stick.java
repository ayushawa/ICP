class Solution {
    public int helper(int cuts[],int i,int j,int t[][]){
        if(i>j) return 0;
        if(t[i][j] != -1) return t[i][j];
        int mini  = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            mini = Math.min(mini,cuts[j+1]-cuts[i-1]+helper(cuts,i,k-1,t)+helper(cuts,k+1,j,t));
        }
        return t[i][j] =  mini;
    }
        
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
         int m = cuts.length;
         int arr[] = new int[m+2];
         for(int i =0;i<m;i++){
            arr[i+1] = cuts[i];
         }  
         arr[m+1] = n;

         int t[][] = new int[m+2][m+2];
         for(int i=0;i<m+2;i++){
            Arrays.fill(t[i],-1);
         }
         return helper(arr,1,m,t);
    }
}