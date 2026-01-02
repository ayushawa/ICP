class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long scores[] = new long[n];
        for(int i =0;i<n;i++){
            scores[edges[i]]+=i;
        }

        int idx = 0;
        long maxiscore = 0;
        for(int i = 0;i<n;i++){
            if(scores[i]>maxiscore){
                maxiscore = scores[i];
                idx  = i;
            }
        }
        return idx;
    }
}