class Solution {
   
    public int maxProfit(int[] arr) {
        int n  = arr.length;
        int prev[][] = new int[3][2];
        int curr[][] = new int[3][2];
        for(int i=n-1;i>=0;i--){
            for(int cap = 1;cap<3;cap++){
                for(int buy = 0;buy<2;buy++){
                    if(buy == 1) curr[cap][buy] = Math.max(-arr[i]+prev[cap][0],curr[cap][buy]);
                     else  curr[cap][buy] = Math.max(arr[i]+prev[cap-1][1],curr[cap][buy]);
                }
               
            }
            prev = curr;
        }
        return prev[2][1];
    }
}