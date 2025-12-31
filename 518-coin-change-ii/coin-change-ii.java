class Solution {
   
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) prev[i] = 1;
        }
        for(int i = 1;i<n;i++){
            int curr[] = new int[amount+1];
            for(int j=0;j<=amount;j++){
                int take = 0;
                if(j>=coins[i]) take = curr[j-coins[i]];
                int nottake = prev[j];
                curr[j] = take + nottake;
            }
            prev = curr;
        }
        return prev[amount];

    }
}