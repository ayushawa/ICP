class Solution {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        long rev[]  = new long[n];
        for(int i =0;i<n;i++){
            long val = (long)nums[i];
            long num = 0;
            while(val>0){
                long r =(long)val%10;
                val = val/10;
                num= num*10 + r;
            }
            rev[i] = (long)nums[i] - num;
            
        }
        Arrays.sort(rev);
        
        int mod = (int)1000000007;
        int count = 0;
        int prev = 0;
        for(int i=1;i<n;i++){
   
            if(rev[i] == rev[prev]) count = (count + i-prev)%mod;
            else prev = i;
        }
        return count;

    }
}