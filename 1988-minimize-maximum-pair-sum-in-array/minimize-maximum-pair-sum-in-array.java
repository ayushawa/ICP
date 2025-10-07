class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            sum = Math.max(sum,nums[s]+nums[e]);
            s++;
            e--;
        }
        return sum;
    }
}