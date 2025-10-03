class Solution {
    public void helper(int arr[],int i,int k,List<Integer> list,List<List<Integer>> ans){
        if(k==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=arr.length ) return;

        list.add(arr[i]);
        helper(arr,i+1,k-1,list,ans);
        list.remove(list.size()-1);
        
        helper(arr,i+1,k,list,ans);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        helper(arr,0,k,new ArrayList<>(),ans);
        return ans;
    }
}