class Solution {
    public int minimumOperations(int[] nums) {
        int count =0;
        for(int x: nums){
            if(x%3 == 1 || x%3 == 2) count++;
        }
        return count;
    }
}