class Solution {
    static class Pair{
        int ind,x,health;
        char dir ; 
        Pair(int ind,int x,int health,char dir){
            this.ind = ind;
            this.x = x;
            this.health = health;
            this.dir = dir;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
           Pair arr[]  = new Pair[n];
           for(int i =0;i<n;i++){
            arr[i] = new Pair(i,positions[i],healths[i],directions.charAt(i));
           }
           Arrays.sort(arr,(a,b)->Integer.compare(a.x,b.x));
        Stack<Pair> st = new Stack<>();
        for(int i = 0;i<n;i++){
            int currx = arr[i].x;
            int currind = arr[i].ind;
            int currhealth = arr[i].health;
            char currdir = arr[i].dir;
            if(st.isEmpty() || st.peek().dir=='L'){
                st.push(new Pair(currind,currx,currhealth,currdir));
            }
            else if(currdir == 'R') {
                st.push(new Pair(currind,currx,currhealth,currdir));
            }
            else {
                boolean add = true;
                while(!st.isEmpty() && st.peek().dir=='R' && currdir=='L'){
                    if(st.peek().health == currhealth){
                        st.pop();
                        add = false;
                        break;
                    }
                    else if(st.peek().health < currhealth){
                        st.pop();
                        currhealth--;
                    }
                    else {
                        st.peek().health--;
                        add = false;
                        break;
                    }
                   
                }
                 if(add) st.push(new Pair(currind,currx,currhealth,currdir));
                
            }
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!st.isEmpty()){
            Pair p = st.pop();
            map.put(p.ind,p.health);
        }
        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;

    }
}