class Solution {
    public int totalSteps(int[] nums) {
        int n= nums.length;
        int dp[] = new int[n];
        int ans = 0;
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<n;i++){
            int maxstep = 0;
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                maxstep = Math.max(maxstep,dp[st.pop()]);
            }

            if(st.isEmpty()) dp[i] = 0;
            else dp[i] = 1 + maxstep;

            ans = Math.max(dp[i],ans);
            st.push(i);
        }
        return ans;
    }
}