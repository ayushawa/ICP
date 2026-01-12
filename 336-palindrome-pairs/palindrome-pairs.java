class Solution {
    public boolean isPalindrome(String s){
        int i= 0;
        int e = s.length()-1;
        while(i<=e){
            if(s.charAt(i)!=s.charAt(e)) return false;
            i++;
            e--;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        int n= words.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(words[i]);
            map.put(sb.reverse().toString(),i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=words[i].length();j++){
                String pref = words[i].substring(0,j);
                String suff = words[i].substring(j);

                if(isPalindrome(pref) && map.containsKey(suff) && map.get(suff)!=i){
                    ans.add(new ArrayList<>());
                    ans.get(ans.size()-1).add(map.get(suff));
                    ans.get(ans.size()-1).add(i);
                }

                if(j!=words[i].length() &&  isPalindrome(suff) && map.containsKey(pref) && map.get(pref) != i){
                    ans.add(new ArrayList<>());
                     ans.get(ans.size()-1).add(i);
                    ans.get(ans.size()-1).add(map.get(pref));
                   
                }
            }
        }
        return ans;
    }
}