/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node node2 = q.poll();
            for(Node neigh:node2.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val));
                    q.add(neigh);
                }

                map.get(node2).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);
    }
}