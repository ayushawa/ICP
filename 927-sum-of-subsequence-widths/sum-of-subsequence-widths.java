class Solution {
    
    public int sumSubseqWidths(int[] nums) {
        long maxsum  = 0;
        long minsum =0;
        int n = nums.length;
        Arrays.sort(nums);
        long mod = (long)1e9 + 7;
        long pow[] = new long[n];
        pow[0] = 1;
        for(int i=1;i<n;i++){
            pow[i] = (pow[i-1] * 2)%mod;
        }
        for(int i=0;i<n;i++){
           
            maxsum = (maxsum +  ((long)nums[i] * pow[i])%mod)%mod;
    
            minsum = (minsum +  ((long)nums[i] * pow[n-1-i])%mod)%mod;
            
        }
        return (int)((maxsum  - minsum + mod)%mod);
    }
}