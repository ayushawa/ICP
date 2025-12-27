class Solution {
    public int gcd(int a,int b){
        int n = a<b? a: b;
        for(int i=n;i>0;i--){
            if(a%i == 0 && b %i==0) return i;
        }
        return -1;
    }
    public int countBeautifulPairs(int[] nums) {
        int n= nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        for(int i=0;i<n;i++){
            right[i] = nums[i]%10;
            if(nums[i]<10) {
                left[i] = nums[i];
                continue;
            }
            int a =  nums[i]/10;
            String st = String.valueOf(a);
            left[i] = Integer.valueOf(st.substring(0,1));
        
        }
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(gcd(left[i],right[j]) == 1) count++;
            }
        }
        return count;
    }
}