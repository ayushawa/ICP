class Solution {
    public int distMoney(int money, int children) {
        if(money<children) return -1;
        int count  = money/8;
        if(count == 0) return 0;
        int rem = money%8;
        int target = money;
        if(money - 8 * (target/8)==4 && children-count == 1) {
            return count-1;
        }
        else if(count<=children && money- 8 * (money/8)!=0 && children-count==0) return count-1;
        else if(count<=children && money- 8 * (money/8)>=children-count) return count;
        else  if(count <= children &&  money- 8 * (money/8)<children-count){
            int total = children-count- (money- 8 * (money/8));
            int r = total/7;
            if(total%7!=0) r++;
            return count-r;
        }
        else if(count>children ) return children-1;
       
        else return 0;
    }
}