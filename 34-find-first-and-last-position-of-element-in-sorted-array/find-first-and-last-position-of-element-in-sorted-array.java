class Solution {
    public int firstOccurence(int nums[],int target){
        int ind = -1;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int m= s + (e-s)/2;
            if(nums[m] == target){
                ind = m;
                e  = m-1;
            }
            else if(nums[m]>target) e = m-1;
            else s = m+1;
        }
        return ind;
    }
    public int lastOccurence(int nums[],int target){
        int s = 0;
        int e = nums.length-1;
        int ind = -1;
        while(s<=e){
            int m= s + (e-s)/2;
            if(nums[m] == target) {
                ind = m;
                s = m+1;
            }
            else if(nums[m]>target) e= m-1;
            else s = m+1;
        }
        return ind;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0] = firstOccurence(nums,target);
        ans[1] = lastOccurence(nums,target);
        return ans;
    }
}