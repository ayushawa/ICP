class Solution {
    public int helper(int nums[],int i,int j,int score,int dp[][]){
        if(i>=j) return 0;
        if(i>=nums.length || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
         
         int left = 0;
         if (i+1<=j && nums[i]+nums[i+1]==score ){
            left = 1 + helper(nums,i+2,j,nums[i]+nums[i+1],dp);
         }

         int both =0;
         if( nums[i]+nums[j] == score){
            both = 1 + helper(nums,i+1,j-1,nums[i]+nums[j],dp);
         }

         int right = 0;
         if( j-1>=i && nums[j]+nums[j-1] == score){
            right = 1 + helper(nums,i,j-2,nums[j]+nums[j-1],dp);
         }

         return dp[i][j] = Math.max(left,Math.max(both,right));

    }
    public int maxOperations(int[] nums) {
    
        int ans = 0;
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        ans = Math.max(ans,1 + helper(nums,2,n-1,nums[0]+nums[1],dp));
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        ans = Math.max(ans,1 + helper(nums,0,n-3,nums[n-1]+nums[n-2],dp));
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        ans = Math.max(ans,1 + helper(nums,1,n-2,nums[0]+nums[n-1],dp));
        return ans;
    }
}