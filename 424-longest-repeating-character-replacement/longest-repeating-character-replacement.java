class Solution {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        int j=0;
        int maxi = 0;
        int maxifreq = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map[ch-'A']++;
           maxifreq = Math.max(maxifreq,map[ch-'A']);
            
            if(i-j+1-maxifreq>k){
                 char temp = s.charAt(j);
               map[temp-'A']--;
               maxifreq = 0;
               for(int x:map){
                maxifreq = Math.max(maxifreq,x);
               }
                j++;
             
            }
            maxi = Math.max(maxi,i-j+1);
        }
        return maxi;
    }
}