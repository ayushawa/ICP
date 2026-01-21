class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum =0;
        long mod = (long)1e9+7;
    
        for(int i=0;i<n;i++){
            int left = i-1;
            int right = i+1;
            while(left>=0 && arr[left]>=arr[i]){
                left--;
            }

            while(right<n && arr[right]>arr[i]){
                right++;
            }
            left =i- left;
            right = right-i;
           
            sum =( sum + ((long)arr[i]*left*right)%mod)%mod;
            

        }
        return (int)sum;
    }
}