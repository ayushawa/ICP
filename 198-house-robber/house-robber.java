class Solution {
   
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int nottake  = dp[i-1];
            int take = nums[i];
            if(i>=2) take += dp[i-2];
            dp[i] = Math.max(take,nottake);
        }
        return dp[n-1];
    }
}