class Solution {
    public String arrangeWords(String text) {
       String str[] = text.split(" ");
       Arrays.sort(str,(a,b)->a.length()-b.length());
       StringBuilder sb =new StringBuilder();
       for(int i =0;i<str.length;i++) {
         String s = str[i].toLowerCase();
         if(i == 0){
            sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1,s.length()));
            sb.append(" ");
         }
         else {
            sb.append(s);
           if(i!=str.length-1) sb.append(" ");
         }
         
       }  
       return sb.toString(); 
    }
}