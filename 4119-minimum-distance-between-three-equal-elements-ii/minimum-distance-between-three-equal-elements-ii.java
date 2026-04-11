class Solution {
    public int minimumDistance(int[] nums) {
        int  n  = nums.length;
        int mini = Integer.MAX_VALUE;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size()>=3){
                ArrayList<Integer> l = map.get(nums[i]);
                mini = Math.min(mini,l.get(1)-l.get(0)+l.get(2)-l.get(1)+l.get(2)-l.get(0));
                map.get(nums[i]).remove(0);
            }
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;

        
    }
}