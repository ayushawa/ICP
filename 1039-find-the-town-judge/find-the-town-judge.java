class Solution {
    public int findJudge(int n, int[][] trust) {
        int map[][] = new int[n+1][2];
        for(int i =0;i<trust.length;i++){
            if(trust[i][0] == trust[i][1]) continue;
            map[trust[i][1]][1]++;
            map[trust[i][0]][0]++;

        }

        for(int i=1;i<n+1;i++){
            if(map[i][0] == 0 && map[i][1] == n-1) return i;
        }
        return -1;
    }
}