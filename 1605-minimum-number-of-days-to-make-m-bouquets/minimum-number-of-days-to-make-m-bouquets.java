class Solution {
    public int countBucket(int arr[],long mid,int k){
        int bucket = 0;
        int count = 0;
        for(int i : arr){
            if((long)i> mid){
                count = 0;
            }
            else count++;
            
            if(count == k){
                
                count = 0;
                bucket++;
            }
          
        }
        return bucket;
    }
    public int minDays(int[] bloomDay, int m, int k) {
         long s = Long.MAX_VALUE;
         long e = Long.MIN_VALUE;
         for(int i : bloomDay){
            s = Math.min(s,(long)i);
            e= Math.max(e,(long)i);
         }
         int ans = -1;
         while(s<=e){
            long mid = s + (e-s)/2;
            int numOfBucket = countBucket(bloomDay,mid,k);
           // System.out.println(numOfBucket);
            if(numOfBucket >= m){
                ans = (int)mid;
                e = mid-1;
            }
            else s = mid+1;
         }
         return ans;

    }
}