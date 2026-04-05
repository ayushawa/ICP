class Solution {
    public int helper(int arr[],int i,int k,int dp[]){
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int maxi = Integer.MIN_VALUE;
        int val = Integer.MIN_VALUE;
        for(int j= i;j<i+k && j<arr.length ;j++){
            val = Math.max(arr[j],val);
            maxi = Math.max(maxi,val * (j-i+1) + helper(arr,j+1,k,dp));
        }
        return dp[i] =  maxi;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,0,k,dp);
    }
}