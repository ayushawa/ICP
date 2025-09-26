class Solution {
    public int firstPosition(int nums[],int k){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m] == k){
                ans = m;
                e  = m-1;
            }
            else if(nums[m]> k){
                e = m-1;
            }
            else s = m+1;
        }

        return ans;
    }

    public int secondPosition(int nums[],int k){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m] == k){
                ans = m;
                s =m+1;
            }
            else if(nums[m]> k){
                e = m-1;
            }
            else s = m+1;
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int a = firstPosition(nums,target);
        int b = secondPosition(nums,target);
        int ans[] = {a,b};
        return ans;
    }
}