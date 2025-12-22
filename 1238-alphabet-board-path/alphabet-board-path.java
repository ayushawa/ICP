class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public String alphabetBoardPath(String target) {

       List<String> l  =new ArrayList<>();
       l.add("abcde");
       l.add("fghij");
       l.add("klmno");
       l.add("pqrst");
       l.add("uvwxy");
       l.add("z");
        HashMap<Character,Pair> map =new HashMap();
        for(int i = 0;i<l.size();i++){
            for(int j=0;j<l.get(i).length();j++){
                Pair p = new Pair(i,j);
                map.put(l.get(i).charAt(j),p);
            }
        }

        StringBuilder sb =new StringBuilder();
        int sx = 0;
        int sy = 0;
        for(int k =0;k<target.length();k++){
            char ch = target.charAt(k);
            Pair p = map.get(ch);

            int xi = p.x;
            int yi = p.y;
            if(xi == 5 && yi==0){
                for(int i = 0;i<xi-sx-1;i++){
                sb.append('D');
                }
                for(int i = 0;i<sy-yi;i++){
                sb.append('L');
                }
               if(sx != 5) sb.append('D');
                sb.append('!');
                sx = xi;
                sy = yi;
                continue;
            }
            for(int i = 0;i<xi-sx;i++){
                sb.append('D');
            }
            for(int i = 0;i<sx-xi;i++){
                sb.append('U');
            }
            for(int i = 0;i<yi-sy;i++){
                sb.append('R');
            }
            for(int i = 0;i<sy-yi;i++){
                sb.append('L');
            }
            sb.append('!');
            sx = xi;
            sy = yi;
        }
        return sb.toString();
    }
}