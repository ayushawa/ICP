class Solution {
  
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean dp[]  = new boolean[n];
        dp[0] = false;
        if(nums[0] == nums[1]) dp[1] = true;
        for(int i=2;i<n;i++){
            if(dp[i-2] == true){
                if(nums[i-1] == nums[i]) dp[i] = true;
            }
            if(i == 2){
                 if(nums[i]==nums[i-1] && nums[i-1] == nums[i-2]) dp[i] = true;
                else if(nums[i]==nums[i-1]+1 && nums[i-1]==nums[i-2]+1) dp[i] = true;
            }
            else if(i-3>=0 && dp[i-3] == true){
                if(nums[i]==nums[i-1] && nums[i-1] == nums[i-2]) dp[i] = true;
                else if(nums[i]==nums[i-1]+1 && nums[i-1]==nums[i-2]+1) dp[i] = true;
            }
           
        }
        return dp[n-1];
    }
}