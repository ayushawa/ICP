class Solution {
    public boolean isNStraightHand(int[] arr, int size) {
        int  n = arr.length;
        if(n%size!= 0) return false;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int x: arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        for(int k = 0;k<n/size;k++){
            int i = 0;
            int last = -1;
            for(int key: map.keySet()){
                int val = map.get(key);
                if(val==0) continue;
                if(last == -1 || key==last+1){
                    map.put(key,val-1);
                    i++;
                    last = key;
                }
                else return false;
                if(i == size) break;
            }
            if(i != size) return false;
        }
        return true;
    }
}