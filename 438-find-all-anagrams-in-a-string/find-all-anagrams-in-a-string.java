class Solution {
    public boolean isAnagram(int map1[],int map2[]){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> list =new ArrayList<>();
        if(p.length()>s.length()) return list;
        int map1[] = new int[26];
        int map2[] =new int[26];
        for(char ch : p.toCharArray()){
            map2[ch-'a']++;
        }

        for(int i=0;i<k;i++){
            map1[s.charAt(i)-'a']++;
        }
        if(isAnagram(map1,map2)) list.add(0);

        for(int i=k;i<s.length();i++){
            map1[s.charAt(i)-'a']++;
            map1[s.charAt(i-k)-'a']--;
            if(isAnagram(map1,map2)) list.add(i-k+1);
        }
        return list;
    }
}