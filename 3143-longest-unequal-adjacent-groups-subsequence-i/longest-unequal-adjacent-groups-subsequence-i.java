class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int dp[] = new int[n];
        int path[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            path[i] = i;
        }
        int ind = 0;
        int maxi = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(groups[i] != groups[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                ind = i;
            }
        }
        List<String> l =new ArrayList<>();
        l.add(words[ind]);
        while(ind!=path[ind]){
            l.add(0,words[path[ind]]);
            ind = path[ind];
        }
        return l;
    }
}