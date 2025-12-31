class Solution {
    
    public int rob(int[] nums) {
        int n= nums.length;
        int last = nums[0];
        int sec_last = 0;
        for(int i=2;i<=n;i++){
            int temp = Math.max(nums[i-1] + sec_last,last);
            sec_last = last;
            last = temp;
            
        }
        return last;
        
    }
}