class Solution {
    public boolean completeTrip(int time[],long t,int totalTrips){
        long count = 0;
        for(int x: time){
            count+= t/(long)x;
            if(count>= totalTrips) return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
       long s = 1;
       long e =0;
       for(int x: time){
           e = Math.max(e,x);
       } 
       e = e *totalTrips;
       long ans = 100000007;
       while(s<=e){
         long m = s + (e-s)/2;
         if(completeTrip(time,m,totalTrips)){
            ans = m;
            e = m-1;
         }
         else s = m+1;
       }
       return ans;
    }
}