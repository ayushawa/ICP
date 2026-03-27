class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long prev[] = new long[2];
        for(int i = n-1;i>=0;i--){
            long curr[] = new long[2];
            for(int even = 0;even<=1;even++){
                if(even == 1){
                    curr[even] = Math.max((long)nums[i] + prev[0],prev[1]);
                }
                else curr[even] = Math.max(-(long)nums[i] + prev[1],prev[0]);
            }
            prev = curr;
        }
        return prev[1];
    }
}