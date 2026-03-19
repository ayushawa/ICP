class Pair{
    int ind,val;
    Pair(int ind,int val){
        this.ind = ind;
        this.val = val;
    }
}
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> maxP = new PriorityQueue<>((a,b)->b.val - a.val);
        PriorityQueue<Pair> minP = new PriorityQueue<>((a,b)->a.val - b.val);
        int maxlen = 1;
        int maxi = nums[0];
        int mini = nums[0];
        maxP.add(new Pair(0,nums[0]));
        minP.add(new Pair(0,nums[0]));
        int j=0;
        for(int i=1;i<nums.length;i++){
            while(Math.abs(maxi - nums[i])> limit || Math.abs(mini-nums[i])>limit){

                j++;
                while(!maxP.isEmpty() && maxP.peek().ind < j) maxP.poll();
                while(!minP.isEmpty() && minP.peek().ind < j) minP.poll();
                maxi = !maxP.isEmpty() ? maxP.peek().val : nums[i];
                mini = !minP.isEmpty() ? minP.peek().val : nums[i];
            }
            minP.add(new Pair(i,nums[i]));
            maxP.add(new Pair(i,nums[i]));
            maxi = Math.max(maxi,nums[i]);
            mini = Math.min(mini,nums[i]);
            maxlen = Math.max(maxlen,i-j+1);
        }
        return maxlen;
        
    }
}