class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long prev[] = new long[2];
        long preveven  = 0;
        long prevodd = 0;

        for(int i = n-1;i>=0;i--){
            long curreven = 0;
            long currodd = 0;
            for(int even = 0;even<=1;even++){
                if(even == 1){
                    curreven= Math.max(nums[i] + prevodd,preveven);
                }
                else currodd = Math.max(-nums[i] + preveven,prevodd);
            }
            preveven  = curreven;
            prevodd = currodd;
        }
        return preveven;
    }
}