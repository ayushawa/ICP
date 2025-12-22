class Solution {
    public boolean isNice(int map1[],int map2[]){
        for(int i = 0;i<26;i++){
            if(map1[i] !=0 && map2[i] == 0) return false;
            else if(map1[i] == 0 && map2[i] != 0) return false;
        }
        return true;
    }
    public String longestNiceSubstring(String s) {
        
        int len = 0;
        int maxi = 0;
        int si = 1;
        int ei = 1;
        for(int i=0;i<s.length();i++){
            StringBuilder sb =new StringBuilder();
            int map1[] = new int[26];
             int map2[] = new int[26];
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                if(ch>= 'a' && ch<='z'){
                    map1[ch-'a']++;
                }
                else map2[ch-'A']++;
                if(isNice(map1,map2)){
                    if(maxi<j-i+1){
                        maxi = j-i+1;
                        si = i;
                        ei = j+1;
                    }
                }
            }
        }
        return s.substring(si,ei);
        
    }
}