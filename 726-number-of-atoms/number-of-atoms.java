class Solution {
    public String countOfAtoms(String s) {
        Stack<HashMap<String,Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int ind = 0;
        while(ind<s.length()){
            char ch = s.charAt(ind);
            if(ch == '('){
                st.push(new HashMap<>());
                ind++;
            }
            else if(ch == ')'){
                HashMap<String,Integer> curr = st.pop();
                ind++;
                StringBuilder muntiple = new StringBuilder();
                while(ind< s.length() && Character.isDigit(s.charAt(ind))){
                    muntiple.append(s.charAt(ind));
                    ind++;
                }

                int mul = 1;

                if(muntiple.length()>0 &&  muntiple.charAt(0)>'0'){
                    mul = Integer.valueOf(muntiple.toString());
                }

                for(String key : curr.keySet()){
                    curr.put(key,curr.get(key) * mul);
                }

                for(String key : curr.keySet()){
                    st.peek().put(key,st.peek().getOrDefault(key,0)+ curr.get(key));
                }
            }
            else {
               StringBuilder element =new StringBuilder();
               element.append(ch);
               ind++;
               while(ind<s.length() && s.charAt(ind)>='a' && s.charAt(ind)<='z'){
                     element.append(s.charAt(ind));
                     ind++;
               }

                StringBuilder muntiple = new StringBuilder();
                while(ind< s.length() && Character.isDigit(s.charAt(ind))){
                    muntiple.append(s.charAt(ind));
                    ind++;
                }

                int mul = 1;

                if(muntiple.length()>0 &&  muntiple.charAt(0)>'0'){
                    mul = Integer.valueOf(muntiple.toString());
                }

                st.peek().put(element.toString(),st.peek().getOrDefault(element.toString(),0)+mul);
            }
        }
        TreeMap<String,Integer> map = new TreeMap<>(st.pop());
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            sb.append(key);
            if(map.get(key)>1){
                sb.append(String.valueOf(map.get(key)));
            }
        }
        return sb.toString();
    }
}