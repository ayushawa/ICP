class Solution {
    
    public int minimumSubarrayLength(int[] nums, int k) {
       int mini = Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
          int or = 0;
          for(int j=i;j<nums.length;j++){
            or = or|nums[j];
            if(or>=k){
                mini = Math.min(mini,j-i+1);
                break;
            }
          }
       }
       if(mini == Integer.MAX_VALUE) return -1;
       return mini;

    }
}