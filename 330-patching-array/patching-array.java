class Solution {
    public int minPatches(int[] nums, int n) {
        long sum =0;
        int ind = 0;
        long count = 0;
    
        while(sum < n){
            if(ind < nums.length && nums[ind]<= sum + 1){
                sum += (long)nums[ind];
                ind++;
            }
            else {
                sum += (sum + (long)1);
                count++;
            }
        }
        return (int)count;
    }
}