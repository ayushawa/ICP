class Solution {
    public int findArea(int dp[]){
        int n = dp.length;
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = dp[i];
        }
        Arrays.sort(temp);
        int leftS[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && temp[st.peek()]>= temp[i]){
                st.pop();
            }
            leftS[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        int rightS[] = new int[n];
        for(int i=n-1;i>=0;i--){
            if(!st.isEmpty() && temp[st.peek()]>= temp[i]){
                st.pop();
            }
            rightS[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
            
        }
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int area = temp[i] * (rightS[i] - leftS[i]-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[] = new int[m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 1) dp[j]++;
                else dp[j] = 0;
            }
            ans = Math.max(ans,findArea(dp));

        }
        return ans;
    }
}