class Solution {
    public int findFirst(int nums[],int target){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m] == target){
                ans = m;
                e = m-1;
            }
            else if(nums[m]>target) e = m-1;
            else s = m+1;
        }
        return ans;
    }
    public int findSecond(int nums[],int target){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m] == target){
                ans = m;
                s=m+1;
            }
            else if(nums[m]>target) e = m-1;
            else s = m+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        int first = findFirst(nums,target);
        int second = findSecond(nums,target);
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
}