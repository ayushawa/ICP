class Solution {
    public int totalSteps(int[] nums) {
        Stack<Integer> st =new Stack<>();
        int dp[] = new int[nums.length];
        int ans =0;
        for(int i=0;i<nums.length;i++){
            int maxcount = 0;
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                maxcount = Math.max(maxcount,dp[st.pop()]);
            }
            if(st.isEmpty()) dp[i] = 0;
            else dp[i] = 1 + maxcount;

            ans = Math.max(dp[i],ans);
            st.push(i);
        }

        return ans;
    }
}