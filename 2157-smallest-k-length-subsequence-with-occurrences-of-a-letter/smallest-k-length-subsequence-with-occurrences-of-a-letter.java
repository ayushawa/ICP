class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int countC = 0;
        int size = 0;
        int takenC = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == letter) countC++;
        }
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && size+n-i-1>=k  ){
                if(st.peek() == letter && countC+takenC-1>=repetition){
                    st.pop();
                    takenC--;
                    size--;
                }
                else if(st.peek() == letter) break;
                else  {
                    st.pop();
                    size--;
                }

            }
            
            st.push(ch);
            if(ch == letter){
                 takenC++;
                 countC--;
            }
            size++;
           
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb = sb.reverse();
        int m = sb.length();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            if( sb.charAt(i)==letter){
                ans.append(sb.charAt(i));
                repetition--;
            }
            else if(k-repetition - ans.length()>0){
                ans.append(sb.charAt(i));
            }
            if(ans.length() == k) break;
        }
        return ans.toString();

    }
}