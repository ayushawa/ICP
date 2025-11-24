class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int prev[] = new int[5];
        int curr[] = new int[5];
        for(int i=n-1;i>=0;i--){
            for(int trans = 3;trans>=0;trans--){
                if(trans%2 == 0){
                    // buy 
                    curr[trans] = Math.max(-arr[i] + prev[trans+1],prev[trans]);
                }
                else curr[trans] = Math.max(arr[i]+ prev[trans + 1],prev[trans]);
            }
            prev = curr;
        }

        return prev[0];
    }
}