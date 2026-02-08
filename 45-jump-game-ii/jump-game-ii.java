class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int dp[] = new int[nums.length];

        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            int take = Integer.MAX_VALUE;
            for(int j=i+1;j<=nums[i]+i;j++){
                if(j<n){
                    int temp  = dp[j];
                    if(temp!= Integer.MAX_VALUE) temp++;
                    take = Math.min(take,temp);
                }
            }
            dp[i] = take;
        }
        return dp[0];
    }
}