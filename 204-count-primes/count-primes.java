class Solution {
    public int countPrimes(int n) {
        boolean prime[] = new boolean[n];
        Arrays.fill(prime,true);
        for(int i = 2;i*i<=n-1;i++){
            if(prime[i]){
                for(int j=i*i;j<=n-1;j+=i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(prime[i] == true) count++;
        }
        return count;
        
    }
}