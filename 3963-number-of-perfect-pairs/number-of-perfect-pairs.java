class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long mod[] = new long[n];
        for(int i=0;i<n;i++){
            mod[i] = Math.abs((long)nums[i]);
        }
        Arrays.sort(mod);
        int j =0;
        long count =0;
        for(int i=0;i<n;i++){
            while(j<n && mod[j]<=2 * mod[i]){
                j++;
            }
            count += (j-i-1);
        }
        return count;
    }
}