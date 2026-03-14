class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        int maxi = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int count = 1;
                int curr = num;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                maxi = Math.max(maxi,count);
            }
        }
        return maxi;
    }
}