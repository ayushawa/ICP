class Solution {
    public int helper(int nums[],int i,int dp[]){
        if(i == nums.length-1) return 0;
        else if(i>=nums.length-1) return Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        int take = Integer.MAX_VALUE;
        for(int j=i+1;j<=i+nums[i];j++){
            if(j<nums.length) {
                int temp = helper(nums,j,dp);
                if(temp!= Integer.MAX_VALUE) temp++;
                take = Math.min(take,temp);
            }
        }
        
        return dp[i] =  take;
    }
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}