class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 0) return 1;
        while(n>0){
            int r = n%2 == 1? 0 : 1;

            sb.append(String.valueOf(r));
            n = n/2;
        }
        String s  = sb.reverse().toString();
        
        int ans = Integer.parseInt(s,2);
        return ans;
        


    }
}
