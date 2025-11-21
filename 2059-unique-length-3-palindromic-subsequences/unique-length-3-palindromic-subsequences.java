class Solution {
    public int countPalindromicSubsequence(String s) {
       int count =0;

       for(char ch = 'a';ch<='z';ch++){
           int firstInd = s.indexOf(ch);
           int lastInd  = s.lastIndexOf(ch);

           if(firstInd == -1 || lastInd - firstInd<2) continue;

           boolean check[] = new boolean[26];

           for(int mid = firstInd+1;mid<lastInd;mid++){
               char temp = s.charAt(mid);
               if(check[temp-'a'] == false) {
                  count++;
                  check[temp-'a'] = true;
               }
           }

       }

       return count;
    }
}