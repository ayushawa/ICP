class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int j=0;
        int maxlen = 0;
        for(int i=0;i<nums.length;i++){
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()]<nums[i]) {
                maxDq.pollLast();
            }
            while(!minDq.isEmpty() && nums[minDq.peekLast()] > nums[i]){
                minDq.pollLast();
            }
            maxDq.addLast(i);
            minDq.addLast(i);
            while(nums[maxDq.peekFirst()] - nums[minDq.peekFirst()]>limit){
                if(maxDq.peekFirst() == j) maxDq.pollFirst();
                if(minDq.peekFirst() == j) minDq.pollFirst();
                j++;
            }
            maxlen = Math.max(maxlen,i-j+1);
        }
        return maxlen;
    }
}