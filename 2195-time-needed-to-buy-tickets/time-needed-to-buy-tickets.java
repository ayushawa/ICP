class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n = tickets.length;
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int  idx = q.poll();
            tickets[idx]--;
            count++;
            if(tickets[idx] !=0) q.add(idx);
            else if(idx == k) break;
        }
        return count;
    }
}