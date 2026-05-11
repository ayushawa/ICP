class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i: nums){
            String val = String.valueOf(i);
            for(int j=0;j<val.length();j++){
                char ch = val.charAt(j);
                l.add((int)(ch-'0'));
            }
        }
        int size = l.size();
        int ans[] = new int[size];
        for(int i=0;i<size;i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}