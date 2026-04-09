class Solution {
    public String multiply(String num1, String num2) {
        int n =  num1.length();
        
        int m = 200;
        int matrix[] = new int[200];
        int start = 0;
        for(int i =num2.length()-1;i>=0;i--){
            char ch = num2.charAt(i);
            int val = ch-'0';
            int carry = 0;
            for(int j=0;j<n;j++){
                char ch2 = num1.charAt(n-1-j);
                int val2 = ch2-'0';
                int mul = val * val2 + matrix[j+start]+carry;
                int num = mul % 10;
                
                carry = mul/10;
                matrix[j+start]=num;
            }

            matrix[start+n] = carry;
           
            start++;
            
            

        }

        StringBuilder sb = new StringBuilder();
       for(int i=0;i<200;i++){
           sb.append(String.valueOf(matrix[i]));
       }
       sb = sb.reverse();

       int ind = 0;
       while(ind<200 && sb.charAt(ind)=='0'){
        ind++;
       }
       if(sb.substring(ind,200).length() == 0) return "0";
       return sb.substring(ind,200);
    }
}