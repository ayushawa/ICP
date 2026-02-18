class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = n%2 != 0 ? 1 : 0;
        n =n/2;
        while(n>0){
            int pre = n%2!=0 ? 1 : 0;
            if(pre == last) return false;
            n = n/2;
            last = pre;
        }
        return true;
    }
}