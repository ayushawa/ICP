class Solution {
    public int closest(List<Integer> lis ,int x){
        int s = 0;
        int e   = lis.size()-1;
        int ans =Integer.MAX_VALUE;
        while(s<=e){
            int m = s +(e-s)/2;
            if(lis.get(m) == x ) return 0;
            else if(lis.get(m)<x){
                ans = Math.min(ans,Math.abs(lis.get(m)-x));
                s = m+1;
            }
            else {
                ans = Math.min(ans,Math.abs(lis.get(m)-x));
                e=m-1;
            }
        }
        return ans;
    }
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int mini = Integer.MAX_VALUE;
        List<Integer> lis  = new ArrayList<>();
        for(int i=x;i<nums.size();i++){
            int ind  = Collections.binarySearch(lis,nums.get(i-x));
            if(ind<0){
                ind = -(ind) -1;
                lis.add(ind,nums.get(i-x));
            }
          
            int diff = closest(lis,nums.get(i));
            mini = Math.min(mini,diff);
        }


        return mini;
    }
}