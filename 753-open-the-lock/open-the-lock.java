class Pair{
    String s;
    int k;
    Pair(String s,int k){
        this.s = s;
        this.k = k;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set =new HashSet<>();
        for(String i : deadends){
            set.add(i);
        }
        if(set.contains("0000")) return -1;
   
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000",0));
        set.add("0000");
        
        int ans = 0;
        while(!q.isEmpty()){
            Pair  p = q.poll();
            String s = p.s;
            int k = p.k;
            if(s.compareTo(target) == 0) return k;
            char strs[] = s.toCharArray();
            for(int i =0;i<4;i++){
                char temp = strs[i];
                char ch = strs[i] ;
                
                if(ch == '9') strs[i] = '0';
                else strs[i] = (char)(ch + 1);
                String s1 = new String(strs);
                if(!set.contains(s1)){
                    set.add(s1);
                    q.add(new Pair(s1,k+1));
                }

                if(ch == '0') strs[i] = '9';
                else strs[i] = (char)(ch-1);

                String s2 = new String(strs);
                if(!set.contains(s2)){
                    set.add(s2);
                    q.add(new Pair(s2,k+1));
                }

                strs[i]= temp;
            }
        }
        return -1;


    }
}