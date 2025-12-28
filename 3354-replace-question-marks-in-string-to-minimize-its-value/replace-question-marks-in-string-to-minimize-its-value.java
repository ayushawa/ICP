class Solution {
    public String minimizeStringValue(String s) {
        int map[] = new int[26];
        char chars[] = s.toCharArray();
        int m = 0;
        for(char ch : chars){
            if(ch == '?') m++;
           else map[ch-'a']++;
        }

        char temp[] = new char[m];

        for(int  i =0;i<m;i++){
            int mini = 0;
            for(int j=1;j<26;j++){
                if(map[j]<map[mini]){
                    mini = j;
                }
            }

            temp[i] = (char)('a'+mini);
            map[mini]++;
        }

        Arrays.sort(temp);
        int  i =0;
        for(int k=0;k<chars.length;k++){
            if(chars[k]!='?') continue;
            else chars[k] = temp[i++];
        }
        String ans = new String(chars);
        return ans;
    }
}