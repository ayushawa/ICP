class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n= s.length();
        if(k>n) return false;
        if((1<<k)>n-k+1) return false;
        Set<String> set =new HashSet<>();
        for(int i=0;i+k<=n;i++){
            set.add(s.substring(i,i+k));
            if(set.size() == (1<<k)) return true;
        }
        return false;

    }
}