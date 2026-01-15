class Solution {
    public long maximumScore(int[] nums, String s) {
        long ans = (long)0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(s.charAt(i) == '1'){
                ans+= pq.poll();
            }
        }
        return ans;
    }
}