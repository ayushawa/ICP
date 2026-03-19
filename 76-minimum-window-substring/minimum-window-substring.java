class Solution {
    public boolean isContain(HashMap<Character,Integer> map2,HashMap<Character,Integer> map1){
        
        
        for(char key : map2.keySet()){
            if(!map1.containsKey(key)) return false;
            else if(map1.get(key)<map2.get(key)) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i =0;i<t.length();i++){
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }

        HashMap<Character,Integer> map2  = new HashMap<>();
        int j=0;
        int minlen = Integer.MAX_VALUE;
        int start = -1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            while(isContain(map1,map2)){
                if(minlen > i-j+1){
                    start = j;
                    minlen = i-j+1;
                }
                map2.put(s.charAt(j),map2.get(s.charAt(j))-1);
                if(map2.get(s.charAt(j)) == 0) map2.remove(s.charAt(j));
                j++;
            }
        }
        if(minlen == Integer.MAX_VALUE) return "";
        return s.substring(start,start+minlen);
    }
}