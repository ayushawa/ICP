class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> val = new Stack<>();
        int n = nums.length;
        int mrr[] = new int[n-k+1];
        int nge[] = new int[n];
        val.push(n-1);
        nge[n-1] = n;
        for(int i = n-2;i>=0;i--){
            while(val.size() >0 && nums[val.peek()]<nums[i]) val.pop();
            if(val.size() == 0) nge[i] = n;
            else nge[i] = val.peek();
            val.push(i);
        }
        int j = 0;
        for(int i = 0;i<n-k+1;i++){
            if(j>=i+k) j = i;
            int m = nums[j];
            while(j<k+i){
                m = nums[j];
                j = nge[j];
            }
            mrr[i] = m;
        }
        return mrr;


    }
}