class Solution {
    public void replace(List<Integer> l){
        if(l.size() == 1) return;
        int j=0;
        int sum = l.get(0) + l.get(1);
        for(int i=2;i<l.size();i++){
            if(l.get(i-1)+l.get(i)<sum){
                sum = l.get(i-1) + l.get(i);
                j = i-1;
            }
        }
        l.remove(j);
        l.remove(j);
        l.add(j,sum);
        
    }
    public boolean isSorted(List<Integer> l){
        for(int i= 1;i<l.size();i++){
            if(l.get(i-1)>l.get(i)) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int x : nums){
            l.add(x);
        }
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(isSorted(l)) break;
            replace(l);
            count++;
        }
        return count;
    }
}