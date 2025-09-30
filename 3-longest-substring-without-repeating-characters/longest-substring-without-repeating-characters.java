class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j=0;
        int len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch  = s.charAt(i);
            while(!map.isEmpty() && map.containsKey(ch)){
                char temp  = s.charAt(j);
                map.remove(temp);
                j++;
            }
            map.put(ch,1);
            len = Math.max(len,i-j+1);
        }
        return len;
    }
}