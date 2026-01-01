class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][1];
        int b = edges[0][0];

        int common = 0;
        if(a == edges[1][1] || a == edges[1][0]) common = a;
        else if(b == edges[1][1] || b == edges[1][0]) common = b;
        else return -1;
        for(int i=2;i<edges.length;i++){
            if(common != edges[i][0] && common != edges[i][1]) return -1;
        }
        return common;
    }
}