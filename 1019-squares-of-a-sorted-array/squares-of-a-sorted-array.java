class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int square[] = new int[n];
        int ind = n-1;
        int i=0;
        int j=n-1;
        while(i<=j){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                square[ind--] = nums[j]*nums[j];
                j--;
            }
            else {
                square[ind--] = nums[i]*nums[i];
                i++;
            }
        }
        return square;
    }
}