class Solution {
    public int minimumBuckets(String hamsters) {
        int buckets  = 0;
        char arr[] = hamsters.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] == 'H'){
                if(i>0 && arr[i-1]=='F') continue;

                else if(i+1<n && arr[i+1]=='.'){
                    buckets++;
                    arr[i+1]='F';
                }
                else if(i>0 && arr[i-1]=='.'){
                    arr[i-1]='F';
                    buckets++;
                }
                else return -1;

            }
           
        }
         return buckets;
    }
}