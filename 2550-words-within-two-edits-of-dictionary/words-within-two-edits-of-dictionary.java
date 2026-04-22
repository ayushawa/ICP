class Solution {
    public int diff(String s1,String s2){
        if(s1.length() != s2.length()){
            return 5;
        }
        int count =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) !=s2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> dist =new ArrayList<>();
        for(String s : dictionary){
            dist.add(s);
        }
        int change = 2;
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<queries.length;i++ ){
            if(dist.contains(queries[i])){
                ans.add(queries[i]);
            }
            else {
                for(String s : dist){
                    if(diff(queries[i],s)<=2){
                        ans.add(queries[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}