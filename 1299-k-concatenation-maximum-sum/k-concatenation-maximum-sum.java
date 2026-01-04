class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long maxi =0;
       int mod =(int)((long)1e9+7);
        int n= arr.length;
        long sum = 0;
        long totalsum = 0;
        for(int x: arr) totalsum+=x;

        for(int i=0;i<Math.min(k,2)*n;i++){
            sum = (sum + arr[i%n]);
            if(maxi<sum){
                maxi = sum;
            }
            if(sum<0) sum = 0;
        }

        if(totalsum>0 && k>2){
            maxi+=(k-2)*totalsum;
        }
        
        return (int)(maxi%mod);
    }
}