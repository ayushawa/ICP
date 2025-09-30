class Solution {
    public boolean isPermutation(int arr1[],int arr2[]){
        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;
        int map1[] = new int[26];
        int map2[] = new int[26];
        for(int i=0;i<s1.length();i++){
            map1[s1.charAt(i)-'a']++;
        }

        int k = s1.length();
        for(int i=0;i<k;i++){
            char ch = s2.charAt(i);
            map2[ch-'a']++;
        }
        if(isPermutation(map1,map2)) return true;
        for(int i=k;i<s2.length();i++){
            char ch = s2.charAt(i);
            char temp = s2.charAt(i-k);
            map2[ch-'a']++;
            map2[temp-'a']--;
            if(isPermutation(map1,map2)) return true;
        }
        return false;
    }
}