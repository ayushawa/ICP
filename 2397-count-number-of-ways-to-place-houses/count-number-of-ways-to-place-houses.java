class Solution {
    public int countHousePlacements(int n) {
        long first = 1;
        long second = 1;

        long mod = (long)1e9 + 7;
        for(int i = 1;i<=n;i++){
            long temp = (first + second)%mod;
            first = second;
            second = temp;
        }
        return (int)((second * second)%mod) ;
        
    }
}