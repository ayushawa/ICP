class Solution {
    public String removeDigit(String number, char digit) {
        int ind = -1;
        int n= number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i) == digit){
                ind = i;
            }
            else if(ind!= -1 &&  i == ind+1 && number.charAt(i)>digit){
                break;
            }
        }
        if(ind == n-1) return number.substring(0,ind);
        return number.substring(0,ind)+number.substring(ind+1,n);
    }
}