class Solution {
    public boolean isPossibe(int arr[],long m,int t){
        long count =0;
        for(int x: arr){
            count+= m/x;
            if(count>=t) return true;
        }
        return count>=t;

    }
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 0;
        long s = time[0];
        long e = (long)1e14;
        for(int x: time){
            s = Math.min(s,x);
        }
        while(s<=e){
            long m = s + (e-s)/2;
            if(isPossibe(time,m,totalTrips)){
                ans = m;
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        return ans;
    }
}