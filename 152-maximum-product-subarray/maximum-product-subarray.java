class Solution {
    public int maxProduct(int[] nums) {
        int currmax = 1;
        int currmin = 1;
        int max = nums[0];

        for(int x: nums){
            if(x == 0){
                max = Math.max(0,max);
                currmax = 1;
                currmin = 1;
                continue;
            }
            int temp = currmax ;
            currmax = Math.max(currmax*x ,Math.max(currmin * x,x));
            currmin =  Math.min(temp*x ,Math.min(currmin * x,x));
            max = Math.max(currmax,max);
        }
        return max;
    }
}