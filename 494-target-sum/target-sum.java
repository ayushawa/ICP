class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length ;
        int sum = 0;
        for(int x: nums){
            sum+= x;
        }
        if((sum + target) %2  != 0) return 0;
        target = (sum + target)/2;
        if(target <0) return 0;
        int prev[] = new int[target + 1];

        prev[0] = 1;
        for(int i = n-1;i>=0;i--){
            int curr[] = new int[target + 1];
            for(int j = target;j>=0;j--){
                int take = 0;
                if(j>=nums[i]) take = prev[j-nums[i]];
                int nottake = prev[j];
                curr[j] = take + nottake;
            }
            prev = curr;

        }
        return prev[target];
    }
}