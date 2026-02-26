class Solution {
    public void addOne(StringBuilder sb,int last){
        while(last>=0){
            if(sb.charAt(last)=='0'){
                sb.setCharAt(last,'1');
                return;
            }
            else{
                sb.setCharAt(last,'0');
            }
            last--;
        }
        if(last == -1){
            sb.insert(0,'1');
        }
    }
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int last = sb.length()-1;
        int count = 0;
        int prev = sb.length();
        while(!(last == 0 && sb.charAt(last)=='1')){
            char ch = sb.charAt(last);
            if(ch == '0'){
                last--;
            }
            else {
               addOne(sb,last);
               if(sb.length()>prev){
                last++;
                prev = sb.length();
               }
            }
            count++;  
        }
        return count;
    }
}