class Pair{
    int val;
    char dir;
    Pair(int val,char dir){
        this.val = val;
        this.dir = dir;
    }
}
class Solution {
    public int minReorder(int n, int[][] edges) {
        int count =0;
        List<List<Integer>> inside = new ArrayList<>();
        List<List<Integer>> outside = new ArrayList<>();

        for(int i=0;i<n;i++){
            inside.add(new ArrayList<>());
            outside.add(new ArrayList<>());
        }

        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            inside.get(v).add(u);
            outside.get(u).add(v);
        }

        Queue<Pair> q =new LinkedList<>();
        int visited[] = new int[n];
        visited[0] = 1;
        q.add(new Pair(0,'i'));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int el = p.val;
            char dir = p.dir;
            if(dir == 'o') count++;

            for(int j=0;j<inside.get(el).size();j++){
                int curr = inside.get(el).get(j);

                if(visited[curr] == 0){
                    visited[curr] = 1;
                    q.add(new Pair(curr,'i'));
                }
            }

            for(int j=0;j<outside.get(el).size();j++){
                int curr = outside.get(el).get(j);
                if(visited[curr] == 0){
                     visited[curr] = 1;
                    q.add(new Pair(curr,'o'));
                }
            }
        }

        return count;

    }
   
}