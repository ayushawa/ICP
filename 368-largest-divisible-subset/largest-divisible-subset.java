class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        List<Integer> ans = new ArrayList<>();
        int dp[]  = new int[n];
        int path[] = new int[n];
        for(int i=0;i<n;i++){
            path[i] = i;
            dp[i] = 1;
        }

        int maxi = 1;
        int idx = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0 ){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        path[i] = j;
                    }
                }
            }
            if(maxi<dp[i]){
                maxi = dp[i];
                idx = i;
            }
        }
        
        ans.add(nums[idx]);
        while(idx != path[idx]){
            ans.add(nums[path[idx]]);
            idx = path[idx];
        }
        return ans;
    }
}