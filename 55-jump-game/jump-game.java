class Solution {
    public boolean helper(int nums[],int i){
        if(i == nums.length-1){
            return true;
        }
        boolean ans  = false;
        for(int j=i+1;j<=i+nums[i];j++){
            if(j<nums.length) ans |= helper(nums,j);
        }
        return ans;
    }
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean dp[] = new boolean[n];
        dp[n-1] = true;
        for(int i=n-2;i>=0;i--){
            boolean ans = false;
            for(int j= i+1;j<=i+nums[i];j++){
                if(j<n) ans |= dp[j];
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}