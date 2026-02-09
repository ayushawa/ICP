class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int left[] = new int[n];
        int last = ratings[0];
        left[0] =1;
        for(int i = 1;i<n;i++){
            if(ratings[i]>last){
                left[i] = left[i-1]+1;
            }
            else left[i] = 1;
            last = ratings[i];
        }

        int right[] =new int[n];
        right[n-1] = 1;
        last = ratings[n-1];
        for(int i = n-2;i>=0;i--){
            if(ratings[i]>last){
                right[i] = right[i+1] + 1;
            }
            else right[i] = 1;
            last = ratings[i];
        }

        int ans = 0;
        for(int i =0;i<n;i++){
            ans += Math.max(left[i],right[i]);
        }
        return ans;
    }
}