class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        left[0] = nums[0];
        for(int i=1;i<n;i++){
            left[i] = left[i-1] * nums[i];
        }
        int right = 1;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            if(i !=0){
                ans[i] = left[i-1] * right;
            }
            else {
                ans[i] = right;
            }
            right = right * nums[i];
        }
        return ans;

    }
}