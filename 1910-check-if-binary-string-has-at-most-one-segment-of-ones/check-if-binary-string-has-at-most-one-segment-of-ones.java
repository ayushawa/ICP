class Solution {
    public boolean checkOnesSegment(String s) {
        int one = 0;
        for(int i =1;i<s.length();i++){
            if(s.charAt(i-1)!= s.charAt(i)) {
                one++;
            }
            if(one>1) return false;
        }
        return true;
    }
}