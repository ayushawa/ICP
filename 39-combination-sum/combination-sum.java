class Solution {
    public void helper(int arr[],int i,int target,List<Integer> l, List<List<Integer>> ans){
        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList(l));
            }
            return;
        }
        if(target>=arr[i]){
            l.add(arr[i]);
            helper(arr,i,target-arr[i],l,ans);
            l.remove(l.size()-1);
        }
        helper(arr,i+1,target,l,ans);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
       List<List<Integer>> ans =new ArrayList<>();
       List<Integer> l =new ArrayList<>();
       helper(arr,0,target,l,ans);
       return ans;   
    }
}