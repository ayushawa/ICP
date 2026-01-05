class Solution {
    public int helper(String words[],int i,int prev,int groups[],List<String> l,List<List<String>> ans,int dp[][]){
        if(i == words.length){
            if(l.size() != 0){
                ans.add(new ArrayList<>(l));
            }
            return 0;
        }
        if( prev!=-1 && dp[i][prev] !=-1) return dp[i][prev];

        int take  = 0;
        if(prev == -1 || groups[i] !=groups[prev]){
            l.add(words[i]);
           take = 1 + helper(words,i+1,i,groups,l,ans,dp);
            l.remove(l.size()-1);
        }
       int nottake =  helper(words,i+1,prev,groups,l,ans,dp);
       if(prev!=-1)  dp[i][prev] =  Math.max(take,nottake);
       return   Math.max(take,nottake);
    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<List<String>> ans = new ArrayList<>();
        int n = words.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        helper(words,0,-1,groups,new ArrayList<>(),ans,dp);
        int idx = 0;
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size()>ans.get(i).size()){
                idx = i;
            }
        }
        helper(words,0,-1,groups,new ArrayList<>(),ans,dp);
        return ans.get(idx);

        
    }
}