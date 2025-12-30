
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1 == node2) return node1;
      
        int n = edges.length;
        boolean visited[] = new boolean[n];
        int dist[] = new int[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(node1); 
        visited[node1] = true;
        // q.add(node2);
        // visited[node2] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            int adj = edges[node];
            if(edges[node] != -1 && visited[adj]==false){
                
                dist[adj] = 1 + dist[node];
                visited[adj] = true;
                q.add(adj);
            }
            
        }
        boolean visited2[] = new boolean[n];
        int dist2[] = new int[n];
        q.add(node2);
        visited2[node2] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            int adj = edges[node];
            if(edges[node] != -1 && visited2[adj]==false){
                
                dist2[adj] = 1 + dist2[node];
                visited2[adj] = true;
                q.add(adj);
            }
            
        }
        int mini = Integer.MAX_VALUE;
        int ans = -1;
        for(int i  = 0;i<n;i++){
            if(visited[i] == true && visited2[i] == true){
            
                int d = Math.max(dist[i],dist2[i]);
                if(mini>d){
                 
                    mini = d;
                    ans = i;
                }
            }
        }


        return ans;
    }
}