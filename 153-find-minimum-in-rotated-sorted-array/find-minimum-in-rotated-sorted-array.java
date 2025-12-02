class Solution {
    public int findMin(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        int mini = Integer.MAX_VALUE;
        while(s<=e){
            int m = s +(e-s)/2;
            if(arr[s]<=arr[m]){
                mini = Math.min(mini,arr[s]);
                s=m+1;
            }
            else {
                mini = Math.min(mini,arr[m]);
                e = m-1;
            }
        }
        return mini;
    }
}