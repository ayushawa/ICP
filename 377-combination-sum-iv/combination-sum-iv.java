class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for(int tar = 1;tar<=target;tar++){
            int count =0;
            for(int i : nums){
                if(tar>=i) count += dp[tar-i];
            }
            dp[tar] = count;
        }
        return dp[target];
    
    }
}