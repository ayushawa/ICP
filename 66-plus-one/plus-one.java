class Solution {
    public int[] plusOne(int[] digits) {
        int n  = digits.length;
        int carry  = 1;
        for(int i =n-1;i>=0;i-- ){
            int val = digits[i]+1;
            digits[i] = val%10;
            carry = val/10;
            if(carry == 0) break;
        }
        if(carry == 0) return digits;
        else {
            int ans[] = new int[n+1];
            ans[0] = 1;
            for(int i=0;i<n;i++){
                ans[i+1] = digits[i];
            }
            return ans;
        }
    }
}