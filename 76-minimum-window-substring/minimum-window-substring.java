class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int i=0;
        int j=0;
        int si = 0;
        int ei = 0;
        int size = map.size();
        int minLen = Integer.MAX_VALUE;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0){
                    size--;
                }
            }

            while(size == 0){
                if(i-j+1<minLen){
                    minLen = i-j+1;
                    si = j;
                    ei = i;
                }
                char temp = s.charAt(j);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp)==1){
                        size++;
                    }
                }
                j++;
            }

            i++;
        }
    
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(si,ei+1);
    }
}