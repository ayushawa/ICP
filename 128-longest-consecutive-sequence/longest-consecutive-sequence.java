class Solution {
    public int longestConsecutive(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int last = Integer.MAX_VALUE;
        for(int i : nums){
            map.put(i,1);
            last = Math.min(last,i);
        }
        int count = 0;
        
        int maxcount = 0;
        for(int key : map.keySet()){    
            if(key == last){
                count = 1;
            }
            else if(key == last + 1){
                count++;
                last = key;
            }
            else {
                count = 1;
                last = key;
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }
}