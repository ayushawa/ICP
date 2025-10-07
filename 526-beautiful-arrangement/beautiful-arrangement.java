class Solution {
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int helper(int arr[],int i){
        if(i == arr.length){
            for(int k=0;k<arr.length;k++){
                int ind = k+1;
                if((arr[k]%ind != 0 && ind%arr[k]!=0)){
                    return 0;
                }
            }
            return 1;
        }
        int ans = 0;
        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            int ind = i+1;
           if(arr[i]%ind==0 || ind%arr[i]==0) ans+= helper(arr,i+1);
            swap(arr,i,j);
        }
        return ans;
    }
    public int countArrangement(int n) {
        int arr[] =new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        return helper(arr,0);
    }
}