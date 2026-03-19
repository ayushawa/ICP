class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int count =0;
        int p = 1;
        int j=0;
        for(int i=0;i<nums.length;i++){
            p *= nums[i];
            while(p>= k && j<=i){
                p = p/nums[j];
                j++;
            }
            count += i-j+1;
        }
        return count;
    }
}