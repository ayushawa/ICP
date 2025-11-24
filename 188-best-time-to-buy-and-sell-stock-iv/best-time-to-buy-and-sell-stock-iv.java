class Solution {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        int prev[] = new int[2 * k + 1];
        int curr[] = new int[2 * k+1];
        for(int i=n-1;i>=0;i--){
            for(int trans = 2*k-1;trans>=0;trans--){
                if(trans%2 == 0){
                    // buy 
                    curr[trans] = Math.max(-arr[i]+prev[trans+1],prev[trans]);
                }
                else {
                    curr[trans] = Math.max(arr[i]+prev[trans+1],prev[trans]);
                }
            }
            prev  = curr;
        }
        return prev[0];
    }
}