class Solution {
    public int numSquares(int n) {
        List<Integer> l = new ArrayList<>();
        int num = 1;
        while(num*num<=n){
            l.add(num*num);
            num++;
        }
        int m = l.size();
        int prev[] = new int[n+1];
         for(int i=0;i<=n;i++){
            prev[i] = i;
         }
         for(int i=1;i<m;i++){
            int curr[] = new int[n+1];
            for(int j=0;j<=n;j++){
                int take = Integer.MAX_VALUE;
                if(j>=l.get(i)){
                    take = curr[j-l.get(i)];
                    if(take != Integer.MAX_VALUE) take++;
                }
                int nottake = prev[j];
                curr[j] = Math.min(take,nottake);
            }
            prev = curr;
         }
         return prev[n];

    }
}