class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for(int x: hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        while(!map.isEmpty()){
            int start= map.firstKey();
            for(int i = 0;i<groupSize;i++){
                int count = start + i;
                if(!map.containsKey(count)) return false;

                map.put(count,map.get(count)-1);
                if(map.get(count) == 0) map.remove(count);
            }
        }
        return true;
    }
}