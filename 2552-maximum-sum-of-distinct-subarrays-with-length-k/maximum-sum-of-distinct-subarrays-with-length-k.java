class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        long sum = 0;
        long maxi = 0;
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+= nums[i];
        }
        if(map.size() == k){
            maxi = (long)Math.max(maxi,sum);
        }

        for(int i=k;i<n;i++){
            sum += nums[i] - nums[i-k];
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.size() == k)  maxi = (long)Math.max(maxi,sum);
        }

        return maxi;

    }
}