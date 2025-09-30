class Solution {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        int len = 0;
        int maxfr = 0;
        int i=0;
        int j=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            map[ch-'A']++;
            maxfr  = Math.max(maxfr,map[ch-'A']);
            if(i-j+1-maxfr>k){
                map[s.charAt(j)-'A']--;
                j++;
                maxfr = 0;
            }
            len = Math.max(len,i-j+1);
            i++;
        }
        return len;
    }
}