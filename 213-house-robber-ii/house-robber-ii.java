class Solution {
    public int helper(int nums[],int s,int e){
        int last = nums[s];
        int second_last = 0;
        for(int i=s+2;i<=e;i++){
            int temp = Math.max(nums[i-1]+second_last,last);
            second_last = last;
            last = temp;
        }
        return last;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(helper(nums,0,n-1),helper(nums,1,n));
    }
}