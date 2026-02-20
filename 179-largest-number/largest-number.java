class Solution {
    public String largestNumber(int[] nums) {
       PriorityQueue<String> pq = new PriorityQueue<>((a,b)->(b+a).compareTo(a+b));
       for(int x : nums){
        pq.add(String.valueOf(x));
       }
       StringBuilder sb = new StringBuilder();
       while(!pq.isEmpty()){
        sb.append(pq.poll());
       } 
       String ans = sb.toString();
       int i = 0;
       while(i<ans.length() && ans.charAt(i) == '0') i++;
       if(i == ans.length()) return "0";
       else return ans;
    }
}