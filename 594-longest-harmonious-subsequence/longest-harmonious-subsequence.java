class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int ans = 0;
        for(int key : map.keySet()){
            if(map.containsKey(key-1)){
                ans = Math.max(ans,map.get(key)+map.get(key-1));
            }
            if(map.containsKey(key+1)){
                ans = Math.max(ans,map.get(key)+map.get(key+1));
            }
            
        }
        return ans ;
    }
}