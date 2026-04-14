class Solution {
    public long helper(List<Integer> l,int i,List<Integer> fact,int j, long dp[][]){
        if(i == l.size()) return 0;
        if(j == fact.size()) return Long.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        long leve = helper(l,i,fact,j+1,dp);
        long take = Long.MAX_VALUE;
        if(j < fact.size()){
            take = helper(l,i+1,fact,j+1,dp);
            if(take !=Long.MAX_VALUE) take += Math.abs(l.get(i) - fact.get(j));
        }
        return dp[i][j] =  Math.min(take,leve);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        int n = robot.size();
        int m = factory.length;
        Arrays.sort(factory,(x,y)->Integer.compare(x[0],y[0]));
        List<Integer> fact = new ArrayList<>();
        for(int i = 0;i<factory.length;i++){
            for(int j=0;j<factory[i][1];j++){
                fact.add(factory[i][0]);
            }
        }
        long dp[][] = new long[n][fact.size()];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
         return helper(robot,0,fact,0,dp);
    }
}