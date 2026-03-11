class Solution {
    public int helper(int nums[],int i,int target){
        if(i == -1){
            if(target == 0) return 1;
            else return 0;
        }
       
        int pos = helper(nums,i-1,target - nums[i]);
        int neg = helper(nums,i-1,target + nums[i]);
        return  pos + neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length ;
        

      
        return helper(nums,nums.length-1,target);
    }
}