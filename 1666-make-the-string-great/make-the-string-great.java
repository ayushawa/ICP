class Solution {
    public String makeGood(String s) {
       Stack<Character> st = new Stack<>();
       for(char ch: s.toCharArray()){
          if(!st.isEmpty()){
            int left = st.peek();
            int right = ch;
            if(Math.abs(left-right)==32){
                st.pop();
            }
            else st.push(ch);

          }
          else {
            st.push(ch);
          }
       }  
       StringBuilder sb = new StringBuilder();
       while(!st.isEmpty()){
        sb.append(st.pop());
       } 
       return sb.reverse().toString();
    }
}