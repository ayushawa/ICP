class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
       int n = nums.length;
       int q= queries.length;
       int mod = 1000000007;
       for(int i=0;i<q;i++){
           int li = queries[i][0];
           int ri = queries[i][1];
           int ki = queries[i][2];
           int vi = queries[i][3];

           int idx = li;
           while(idx<=ri){
               nums[idx] = (int)(( (1L * nums[idx] * vi) % mod + mod ) % mod);
               idx += ki;
           }
       }

       int xor = 0;
       for(int i : nums){
           xor= xor ^ i;
       }
       return xor;
    }
}