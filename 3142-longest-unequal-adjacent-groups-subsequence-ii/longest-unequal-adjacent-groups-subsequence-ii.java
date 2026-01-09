class Solution {
    public boolean hammingDistance(String s,String t){
        if(s.length() != t.length()) return false;
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != t.charAt(i)) count++;
            if(count >=2) return false;
        }
        return true;
    }
  
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n= words.length;
        int dp[] = new int[n];
        int path[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            path[i] = i;
        }
        int maxi = 1;
        int ind = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(groups[i]!=groups[j] &&  hammingDistance(words[i],words[j]) ){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        path[i] = j;
                    }
                }
            }
            if(dp[i]>dp[ind]){
                ind = i;
            }
        }

        List<String> l =new ArrayList<>();
        l.add(words[ind]);
        while(ind != path[ind]){
            l.add(0,words[path[ind]]);
            ind = path[ind];
        }
        return l;
    }
}