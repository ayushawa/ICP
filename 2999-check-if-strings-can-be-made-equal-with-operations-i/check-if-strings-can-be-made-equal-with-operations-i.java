class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        char[] ar1 = s1.toCharArray();
        char[] ar2 = s2.toCharArray();
        
            if(ar1[0] != ar2[0] ){
                char temp = ar1[0];
                ar1[0] = ar1[2];
                ar1[2] = temp;
            }
            if(ar1[1] != ar2[1] ){
                char temp = ar1[1];
                ar1[1] = ar1[3];
                ar1[3] = temp;
            }
            for(int i=0;i<4;i++){
                if(ar1[i] != ar2[i]) return false;
            }
           return true;
        
        
    }
}