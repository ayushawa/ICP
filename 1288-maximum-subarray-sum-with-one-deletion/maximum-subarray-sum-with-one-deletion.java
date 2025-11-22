class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 0) return arr[0];
       int noSkipSum = arr[0];
       int skipSum = 0;
       int ans = arr[0];
       for(int i=1;i<arr.length;i++){
          int temp = noSkipSum;
           noSkipSum = Math.max(noSkipSum+arr[i] ,arr[i]);
           if(i == 0) skipSum = Math.max(arr[0],arr[1]);
           else skipSum = Math.max(temp,skipSum+arr[i]);
           ans = Math.max(ans,Math.max(skipSum,noSkipSum));

       }
       return ans;
    }
}