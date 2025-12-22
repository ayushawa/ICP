class Solution {
    public int numWays(String s) {
        int ones = 0;
        int n= s.length();
        for(int i  = 0;i<n;i++){
            if(s.charAt(i) == '1') ones++;
        }
        if(ones%3 != 0) return 0;
        int mod = 1000000007;
        if(ones == 0){
            long cuts = n - 1;
            return (int)((cuts * (cuts - 1) / 2) % mod);
        }

        long firstcount =0;
        long secondcount = 0;
        long count = 0;
        long k = ones/3;

        for(int i =0;i<n;i++){
            if(s.charAt(i) == '1') count++;

            if(count == k) firstcount++;
            else if(count == 2*k) secondcount++;
        }

         return (int)(((firstcount * secondcount) % mod + mod) % mod);

    }
}