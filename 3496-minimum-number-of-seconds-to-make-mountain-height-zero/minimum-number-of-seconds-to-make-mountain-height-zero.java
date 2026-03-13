class Pair{
    int val,count;
     long time;
    Pair(int val,int count,long  time){
        this.val = val;
        this.count = count;
        this.time = time;
    }
}
class Solution {
    public long minNumberOfSeconds(int height, int[] arr) {
        int  n = arr.length;
          PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
          for(int i =0;i<n;i++){
              pq.add(new Pair(arr[i],1,(long)arr[i]));
          }
          long ans = (long)0;
          while(height >0){
              height--;
              Pair p = pq.poll();
              int val = p.val;
              int count = p.count;
              long time = p.time;
              ans = Math.max(ans,time);
              count++;
              time  += ((long)val )* ((long)count);
              pq.add(new Pair(val,count,time));
          }
          return ans;

    }
}