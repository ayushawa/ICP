class Solution {
    public String generateTag(String caption) {
        String strs[] =caption.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        int first = 0;
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length()>0){
                if(first == 0){
                    String s = strs[i].toLowerCase();
                    char ch = strs[i].charAt(0);
                    ch = Character.toLowerCase(ch);

                    sb.append(ch);
                    sb.append(s.substring(1,strs[i].length()));
                    first = 1;
                }
                else {
                    String s = strs[i].toLowerCase();
                    char ch = strs[i].charAt(0);
                    ch = Character.toUpperCase(ch);
                    sb.append(ch);
                    sb.append(s.substring(1,strs[i].length()));
                }
            }
            
        }
        if(sb.length()>100) return sb.substring(0,100);
        return sb.toString();
    }
}