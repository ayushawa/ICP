class Pair{
    int val,ind;
    Pair(int val,int ind){
        this.val = val;
        this.ind = ind;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->y.val - x.val);
        int ans[] = new int[n-k+1];
        int j=0;
        for(int i=0;i<n;i++){
            
            while(!pq.isEmpty() && i-k>=pq.peek().ind){
                pq.poll();
            }
            pq.add(new Pair(nums[i],i));
            if(i>=k-1){
                ans[j++] = pq.peek().val;
            }
        }
        return ans;
    }
}