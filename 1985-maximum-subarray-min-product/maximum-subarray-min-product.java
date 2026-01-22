class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n= nums.length;
        long sum[] = new long[n];
        sum[0] = nums[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        int right[] =  new int[n];
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long maxi = (long)0;
        long mod = (long)1e9 + 7;
        for(int i=0;i<n;i++){
            long totalsum = sum[right[i]-1];
            if(left[i]!=-1) totalsum= totalsum - sum[left[i]];
            long value = ((long)nums[i] * totalsum);
            maxi = (long)Math.max((long)maxi,(long)value);
        }
        return (int)(maxi%mod);


    }
}