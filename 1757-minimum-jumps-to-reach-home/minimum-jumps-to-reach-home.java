class Pair{
    int ind,last,k;
    Pair(int ind,int last,int k){
        this.ind  = ind;
        this.last = last;
        this.k = k;
    }
}
class Solution {
   
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<Integer> set =new HashSet<>();
        for(int i: forbidden){
            set.add(i);
        }
        boolean visited[][] = new boolean[6001][2];
        Queue<Pair> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int ind = p.ind;
            int last = p.last;
            int k = p.k;
            if(ind == x) return k;

            if(!set.contains(ind+a) && ind+a<6001 && visited[ind+a][0]==false){
                visited[ind+a][0] = true;
                q.add(new Pair(ind+a,0,k+1));
            }

            if(!set.contains(ind-b) && ind-b>=0 && last == 0 &&  visited[ind-b][1]==false  ){
                visited[ind-b][1] = true;
                q.add(new Pair(ind-b,1,k+1));
            }
        }
        return -1;
       
 
    }
}