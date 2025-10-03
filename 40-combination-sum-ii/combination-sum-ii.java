class Solution {
    public void helper(int arr[],int ind,int k,List<Integer> l,List<List<Integer>> ans ){
        if(k == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > k) break;

            l.add(arr[i]);
            helper(arr,i+1,k-arr[i],l,ans);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(arr,0,target,l,ans);
        return ans;   
    }
}