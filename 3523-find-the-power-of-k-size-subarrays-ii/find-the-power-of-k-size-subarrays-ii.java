class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
       List<Integer> map = new ArrayList<>();
        int idx = 0;
        int j=0;
        for(int i=0;i<k;i++){
            if(map.isEmpty()) map.add(nums[i]);
            else if(nums[i-1]+1==nums[i]){
                map.add(nums[i]);
            }
            else {
                map.clear();
                map.add(nums[i]);
            }
        }
        ans[idx++] = map.size() ==k? nums[k-1]: -1;
        for(int i=k;i<n;i++){
            if(map.size()==k) map.remove(0);
            if(nums[i-1]+1==nums[i]){
                 map.add(nums[i]);
            }
            else {
                map.clear();
                 map.add(nums[i]);
            }
            ans[idx++] = map.size() ==k? nums[i]: -1;
        }
       return ans;
    }
}