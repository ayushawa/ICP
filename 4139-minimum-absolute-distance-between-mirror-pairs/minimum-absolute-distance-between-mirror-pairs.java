class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
       int mini = Integer.MAX_VALUE;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i =0;i<n;i++){
          if(!map.isEmpty() && map.containsKey(nums[i])){
            mini = Math.min(i-map.get(nums[i]),mini);
          }
          StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
          String st =  sb.reverse().toString();
          int val = Integer.valueOf(st);
          map.put(val,i);
       }
       return mini == Integer.MAX_VALUE ? -1 : mini;

    }
}