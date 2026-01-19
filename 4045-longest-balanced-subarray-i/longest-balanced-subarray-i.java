class Solution {
    public int longestBalanced(int[] nums) {
        int maxi =0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for(int j=i;j<nums.length;j++){
                if(nums[j]%2 == 0){
                    even.add(nums[j]);
                }
                else odd.add(nums[j]);

                
                if(even.size() == odd.size()){
                     maxi = Math.max(maxi,j-i+1);
                  }
            }


        }
        return maxi;
    }
}