class Solution {
    public int helper(int arr[],int limit){
         int ans= 1;
        int sum =arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++){
            sum += arr[i];
            count++;
            if(sum >limit || count>2){
                count = 1;
                sum = arr[i];
                ans++;
            }
        }
        return ans;
    }
    public int numRescueBoats(int[] arr, int limit) {
       int count = 0;
       int s = 0;
       int e = arr.length-1;
       Arrays.sort(arr);
       while(s<=e){
          if(s == e){
            count++;
            s++;
            e--;
          }
          else  if(arr[s]+arr[e]<=limit){
            count++;
            s++;
            e--;
          }else{
            e--;
            count++;
          }
       }
       return count;
    }
}