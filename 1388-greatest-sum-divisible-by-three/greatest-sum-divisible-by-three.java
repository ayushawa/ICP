class Solution {
    public int maxSumDivThree(int[] nums) {
       
        int dp[] = new int[3];
        for(int x: nums){
            int temp[]  = dp.clone();
            for(int r = 0;r<3;r++){
                int newSum = temp[r] + x;
                dp[newSum%3] = Math.max(dp[newSum%3],newSum);
            }
        }

        return dp[0];
    }
}