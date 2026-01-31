class Solution {
    public int merge(int nums[],int s,int m,int e){
        int n= e-s+1;
        int count =0;
        int i = s;
        int j = m+1;
        for(int k=s;k<=m;k++){
            while(j<=e && (long)nums[k]>(long)2 * (long)nums[j]){
                j++;
            }
            count+= j- (m+1);
        }
        int temp[] = new int[n];
        i = s;
        j= m+1;
        int ind =0;
        while(i<=m && j<=e){
            if(nums[i]<=nums[j]){
                temp[ind] = nums[i];
                i++;
            }
            else {
                temp[ind] = nums[j];
                j++;
            }
            ind++;
        }
        while(i<=m){
            temp[ind++] = nums[i++];
        }
        while(j<=e){
            temp[ind++] = nums[j++];
        }
        for(int k=0;k<n;k++){
            nums[s+k] = temp[k];
        }
        return count;
    }
    public int mergeSort(int nums[],int s,int e){
        if(s == e) return 0;
        int m = s + (e-s)/2;
        int count = mergeSort(nums,s,m);
        count+= mergeSort(nums,m+1,e);
        count+= merge(nums,s,m,e);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);

    }
}