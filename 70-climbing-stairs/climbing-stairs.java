class Solution {
    public int helper(int n){
        if(n<0) return 0;
        if(n == 0) return 1;
        return helper(n-1) + helper(n-2);
    
    }
    public int climbStairs(int n) {
        int first = 0;
        int second = 1;
        
        for(int i=2;i<=n+1;i++){
            int third = first + second;
            first = second;
            second = third;
            
        }
        return second;
    }
}