class Solution {
    public void helper(char arr[],int i,int n,int k,String s,List<String> l){
        if(i == n){
            l.add(s);
            return;
        }
        if(l.size()==k) return;
        for(char ch : arr){
            if(i == 0) {
                helper(arr,i+1,n,k,s+ch,l);
            }
            else {
                if(s.charAt(i-1) != ch) helper(arr,i+1,n,k,s+ch,l);
            }
        }
    }
    public String getHappyString(int n, int k) {
    
        char arr[] = {'a','b','c'};
        List<String> l = new ArrayList<>();
        helper(arr,0,n,k,"",l);
        return l.size()>=k ? l.get(k-1): "";
    }
}