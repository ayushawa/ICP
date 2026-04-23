class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        long ans[] = new long[n];
        for(List<Integer> lis  : map.values()){
            int size = lis.size();
            if(size == 1) continue;
            long pref[] = new long[size+1];
            pref[0] = 0;
            for(int i = 1;i<size+1;i++){
                pref[i] = pref[i-1] + lis.get(i-1);
            
            }
            long total = pref[size];

            for(int t = 0;t<size;t++){
                int index = lis.get(t);
                long leftsum = (long)index * t - pref[t];
                long rightsum = (total - pref[t+1]) - (long)index * (size - 1 - t);

                ans[index] = leftsum + rightsum;
            }
        }
        return ans;
    }
}