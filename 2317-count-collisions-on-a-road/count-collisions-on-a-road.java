class Solution {
    public int countCollisions(String directions) {
        char chars[]  =  directions.toCharArray();
        int count = 0;
        Stack<Character> st =new Stack<>();
        st.push(chars[0]);
        for(int i=1;i<chars.length;i++){
            char ch = chars[i];
           if(st.peek()=='S' && ch =='S'){
              
           }
           else if(st.peek()=='S' && ch =='R'){
            st.push(ch);
           }
           else if(st.peek()=='S' && ch =='L'){
            count+=1;
           }
           else if(st.peek() == 'L'){
            st.push(ch);
           }
           else if(ch=='R'){
            st.push(ch);
           }
           else {
              while(!st.isEmpty() && (st.peek()=='R' && ch=='L' || st.peek()=='R' && ch=='S')){
                if(st.peek()=='R' && ch=='L'){
                    count+=2;
                }
                else count+=1;
                st.pop();
                ch = 'S';
              }
              st.push(ch);
           }
        }
        return count;
    }
}