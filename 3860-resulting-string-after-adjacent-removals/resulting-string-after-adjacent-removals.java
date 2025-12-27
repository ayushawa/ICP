class Solution {
    public String resultingString(String s) {
        int n = s.length();

        StringBuilder ans =new StringBuilder();
        ans.append(s.charAt(0));
        for(int i=1;i<n;i++){
            if(ans.length()==0) {
                ans.append(s.charAt(i));
                continue;
            }
            char ch1 = ans.charAt(ans.length()-1);
            char ch2 = s.charAt(i);
            int a = (int)ch1;
            int b = (int)ch2;
            if(Math.abs(a-b)==1) {
               ans.deleteCharAt(ans.length()-1);
            }
            else if((ch1=='a' && ch2=='z') || (ch1=='z' && ch2=='a')) {
                ans.deleteCharAt(ans.length()-1);
            }
            else ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}