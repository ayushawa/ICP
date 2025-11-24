class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int p = 0;
        int n = 0;

        for(int i=0;i<nums.length;i++){
           n = (n * 2 + nums[i]) % 5;
           list.add(n == 0);
        }

        return list;
    }
}