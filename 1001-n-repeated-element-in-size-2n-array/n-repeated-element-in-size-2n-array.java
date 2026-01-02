class Solution {
    public int repeatedNTimes(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
         n = n/2;
        for(int keys: map.keySet()){
            if(map.get(keys) == n) return keys;
        }
        return 0;
    }
}