class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum =0;
        for(int x : nums){
            sum+= x;
        }

        int n= nums.length;
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new HashSet());
        }
        dp.get(0).add(0);

        for(int x: nums){
            for(int k =n-1;k>0;k--){
                for(int prevsum : dp.get(k-1)){
                    dp.get(k).add(x + prevsum);
                }
            }
        }

        for(int k=1;k<n;k++){
            if((sum * k)%n == 0){
                 int target = (sum*k)/n;
                 if(dp.get(k).contains(target)) return true;
            }
        }
        return false;
    }
}