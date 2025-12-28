class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        List<Integer> l =new ArrayList<>();
        for(int i=0;i<k;i++){
            if(l.size() == 0) l.add(nums[i]);
            else if(l.get(l.size()-1)==nums[i]-1){
                l.add(nums[i]);
            }
            else {
                 l.clear();
                 l.add(nums[i]);
            }

        }
        if(l.size() == k) ans[0] = l.get(l.size()-1);
        else ans[0] = -1;
        int ind = 1;
        for(int i=k;i<n;i++){
            if(l.size()!= 0 && l.size() == k) l.remove(0);
            
            if(l.size()==0) l.add(nums[i]);
            else if(l.get(l.size()-1)+1 == nums[i]) l.add(nums[i]);
            else {
                l.clear();
                l.add(nums[i]);
            }
            

            if(l.size()==k) ans[ind++] = l.get(l.size()-1);
            else ans[ind++] = -1;
        }
        return ans;
    }
}