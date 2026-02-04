class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int dp[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            int maxcount =0;
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                maxcount = Math.max(maxcount,dp[st.pop()]);
            }
            if(st.isEmpty()) dp[i] = 0;
            else dp[i] = maxcount + 1;

            ans = Math.max(ans,dp[i]);
            st.push(i);
        }
        return ans;
    }
}