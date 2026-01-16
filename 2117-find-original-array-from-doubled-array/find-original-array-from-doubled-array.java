class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n= changed.length;
        if(n%2 != 0) {
           return new int[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: changed){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int ans[] =new int[n/2];
        int ind = 0;
        Arrays.sort(changed);
        for(int x: changed){
            if(map.get(x) <= 0) continue;

            long dbl = (long)x*2;
            if(dbl>Integer.MAX_VALUE) return new int[0];

            int doubleValue = (int)dbl;
            if(!map.containsKey(doubleValue) || map.get(doubleValue) == 0){
                return new int[0];
            }

            ans[ind++] = x;
            map.put(x,map.get(x)-1);
            map.put(doubleValue,map.get(doubleValue)-1);
        }
        return ans;
        
    }
}