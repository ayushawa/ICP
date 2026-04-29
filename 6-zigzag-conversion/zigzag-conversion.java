class Solution {
    public String convert(String s, int numRows) {
        String strs[] = new String[numRows];
        Arrays.fill(strs,"");
        int n = s.length();
        int j = 0;
        int turn = 0;
        while(j<n){
            
            for(int i = 0;i<numRows && j<n;i++){
                strs[i]+= s.charAt(j);
                j++;
            }
            for(int i=numRows-2;i>=1 && j<n;i--){
                strs[i]+= s.charAt(j);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String st : strs){
            sb.append(st);
        }
        return sb.toString();
    }
}