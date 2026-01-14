class Solution {
    public int minimumOperations(String num) {
        int end0 = -1;
        int end5 = -1;
        if(num.length()==1 && num.charAt(0)!='0') return 1;
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i)=='0' && end0 == -1){
                end0 = i;
            }
            if(num.charAt(i)=='5' && end5 == -1){
                end5 = i;
            }

            if(end5 != -1 && end0 !=-1) break;
        }
        
        

        int i = end0 -1;
        while(i>=0){
            if(num.charAt(i)=='0' || num.charAt(i)=='5'){
                break;
            }
            i--;
        }
         int ans = num.length();
        if(i!=-1)ans =  num.length()-i -2;
        else if(end0 != -1) ans = Math.min(num.length()-1,ans);

        i = end5 -1;
        while(i>=0){
            if(num.charAt(i) =='2' || num.charAt(i)=='7'){
                break;
            }
            i--;
        }
        if(i!=-1) ans = Math.min(ans,num.length()-i-2);
        else if(end5 != -1) ans = Math.min(num.length(),ans);
        return ans;

    }
}