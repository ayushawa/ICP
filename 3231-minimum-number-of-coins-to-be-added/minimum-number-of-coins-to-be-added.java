class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int sum =0;
        int ind = 0;
        int count = 0;
        while(sum < target){
            if(ind<coins.length && coins[ind] <=sum + 1 ){
                sum += coins[ind];
                ind++;
            }
            else {
                sum += (sum + 1);
                count++;
            }
        }   
        return count;
    }
}