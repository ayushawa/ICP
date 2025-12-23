class Solution {
    public String smallestString(String s) {
        StringBuilder sb =new StringBuilder();
        int i = 0;
        int n = s.length();
        int a = 0;
        while(i<n){          
            char ch = s.charAt(i);
            if(ch=='a' && i== 0 && i == n-1){
                sb.append('z');
                i++;
                break;
            }
           else  if(ch == 'a' && i== 0) {

                sb.append(ch);
                a=1;
            }
            else if(a==1 && s.charAt(i-1)!='a' && ch=='a'){
                break;
            }
            else if(a == 1 && i == n-1 && ch=='a' && s.charAt(i-1)=='a'){
                sb.append('z');
                i++;
                break;
            }
            else if(a == 1  && ch=='a' && s.charAt(i-1)=='a'){
                sb.append('a');
            }
            else if(ch!='a'){
                int ascii = (int)ch;
                ascii--;
                char c = (char)ascii;
                sb.append(c);
            }
            else if(ch =='a' && a == 0) {
                break;
            }
            i++;
        }
        sb.append(s.substring(i,n));
        return sb.toString();
    }
}