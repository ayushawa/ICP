class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long mod = 1000000007;
        long first =0;
        long second =0;
        int n = nums1.length, m = nums2.length;
        int i=0,j=0;
        long ans =0;
        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
                ans = ans + (long)Math.max(first,second);
                ans = ans + (long)nums1[i];
                first =(long)0;
                second = (long)0;
                i++;
                j++;
            }
            else if(nums1[i]< nums2[j]) first = first + (long)nums1[i++];
            else second  =second  + (long)nums2[j++];
        }
        while(i<n){
            first = first + (long)nums1[i++];
        }
        while(j<m){
            second = second + (long)nums2[j++];
        }
        ans = (ans + (long)Math.max(first,second))%mod;
        return (int)ans;
    }
}