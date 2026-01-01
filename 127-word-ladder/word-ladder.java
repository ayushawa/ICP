class Pair{
    String s;
    int k = 0;
    Pair(String s,int k){
        this.s = s;
        this.k = k;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<Pair> q =new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String i: wordList){
            set.add(i);
        }
        int ans = 0;
        q.add(new Pair(beginWord,0));
        boolean canMake = false;
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int k = p.k;
            if(s.compareTo(endWord)==0){
                ans = k;
                canMake = true;
                break;
            }
            char[] str = s.toCharArray();
            int n= str.length;
            for(int i=0;i<n;i++){
                char mark = str[i];
                for(char ch='a';ch<='z';ch++){
                    str[i] = ch;
                    String temp = new String(str);
                    if(set.contains(temp)){
                        set.remove(temp);
                        q.add(new Pair(temp,k+1));
                    }
                }
                str[i] = mark;
            } 
        }
        if(canMake) return ans+1;

        return 0;
    }
}