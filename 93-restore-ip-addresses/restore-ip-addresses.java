class Solution {
    public void helper(String s,int i,int count,String newS,List<String> l){
        if(i == s.length()){
            return;
        }
        if(count == 0  ){
            if(s.length()-i >3) return ;
             String temp = s.substring(i,s.length());
            int num = Integer.parseInt(temp);
            if(num >255) return;
            int len = temp.length();
            int check = (int)Math.pow(10,len-1);
            if(num/check <1 && num!=0) return;
            if(num == 0 && temp.length()>1) return;
            newS = newS+temp;
            l.add(newS);
            return;
        }

        for(int j=i;j<i+3 && j<s.length();j++){
            String t = s.substring(i,j+1);
            int val = Integer.parseInt(t);
            int len = t.length();
            int check = (int)Math.pow(10,len-1);
            if(val<=255 && (val/check >=1 || (val==0 && t.length()==1))){
                helper(s,j+1,count-1,newS+t+".",l);
            }
        }

    }
    public List<String> restoreIpAddresses(String s) {
        List<String> lis = new ArrayList<>();
        helper(s,0,3,"",lis);
        return lis;
    }
}