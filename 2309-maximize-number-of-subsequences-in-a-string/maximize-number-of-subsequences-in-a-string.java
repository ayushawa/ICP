class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char ch1 = pattern.charAt(0);
        char ch2 = pattern.charAt(1);
        
        long a = 0;
        long b = 0;
        for(char ch : text.toCharArray()){
            if(ch == ch1) a++;
            else if(ch == ch2) b++;
        }
        if(ch1 == ch2){
            return ( a* (a+1))/2;
        }
        long ans = a>b? a: b;
         a = 0;
        for(char ch: text.toCharArray()){
            if(ch==ch1){
                ans+= b;
            }
            else if(ch == ch2) b--;
        }
        return ans;
    }
}