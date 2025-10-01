class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        
        int n = arr.length;

        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return Integer.compare(a[1],b[1]);
            }
        };
        // Arrays.sort(arr, (a,b) -> Integer.compare(a[1],b[1]));
        Arrays.sort(arr,cmp);
        int c = 1;
        int t = arr[0][1];
        for(int i = 1;i<n;i++){
            if(arr[i][0]>=t) {
                // System.out.println(arr[i][0] + " "+arr[i][1]);
                t = arr[i][1];
                c++;
            }
        
        }
        return n-c;
    }
}