class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxi = 0;
        for(int x: arr){
            int prev = x-diff;
            int freq = map.getOrDefault(prev,0) + 1;
            map.put(x,freq);
            maxi = Math.max(maxi,freq);
        }
        return maxi;
    }
}