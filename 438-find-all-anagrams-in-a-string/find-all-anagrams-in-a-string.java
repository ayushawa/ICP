class Solution {
    public boolean isAnagram(int ar1[],int ar2[]){
        for(int i=0;i<26;i++){
            if(ar1[i] != ar2[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) return list;
        int map1[] = new int[26];
        int map2[] = new int[26];
        for(int i=0;i<p.length();i++){
            map1[p.charAt(i)-'a']++;
        }
        int k = p.length();
        for(int i=0;i<k;i++){
            map2[s.charAt(i)-'a']++;
        }
        if(isAnagram(map1,map2)){
            list.add(0);
        }
        for(int i=k;i<s.length();i++){
            char ch = s.charAt(i);
            char temp = s.charAt(i-k);
            map2[ch-'a']++;
            map2[temp-'a']--;
            if(isAnagram(map1,map2)){
                list.add(i-k+1);
            }
        }
        return list;

    }
}