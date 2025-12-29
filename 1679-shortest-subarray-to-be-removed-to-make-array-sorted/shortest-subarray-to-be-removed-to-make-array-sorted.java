class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
       int s = 0;
       int n = arr.length ;
       while(s< n-1 && arr[s]<=arr[s+1]) s++;
       if(s == n-1) return 0;

       int e = n-1;
       while(e>=s && arr[e]>=arr[e-1]) e--;
       if(e == 0) return n-1;

       int result = Math.min(e,n-s-1);
       int i = 0,j  = e;
       while(i<=s && j<n){
          if(arr[j]>=arr[i]){
            result = Math.min(result ,j-i-1);
            i++;
          }
          else j++;
       }
       return result;
    }
}