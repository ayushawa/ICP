class Solution {
    public int findMaxfreq(HashMap<Character,Integer> map){
        int freq = 0;
        for(char key : map.keySet()){
            freq = Math.max(map.get(key),freq);
        }
        return freq;
    }
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0;
        int maxlen =0;
        int maxfreq = 0;
        for(int i=0;i<s.length();i++){
            char ch  = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfreq = Math.max(map.get(ch),maxfreq);
            while(i-j+1 - maxfreq>k){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                j++;
                maxfreq = findMaxfreq(map);
            }
            maxlen = Math.max(maxlen,i-j+1);
        }
        return maxlen;

    }
}