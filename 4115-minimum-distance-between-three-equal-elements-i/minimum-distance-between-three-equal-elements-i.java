class Solution {
    public int minimumDistance(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int n= nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        mini = Math.min(mini,Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i));
                    }
                }
            }
        }

        return mini == Integer.MAX_VALUE ? -1 : mini;
        
    }
}