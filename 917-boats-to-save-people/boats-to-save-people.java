class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int s =0;
        int count = 0;
        int e = arr.length-1;
        while(s<e){
            int sum = arr[s]+arr[e];
            if(sum <= limit){
                count++;
                arr[s] = -1;
                arr[e] = -1;
                s++;
                e--;
            }
            else if(sum <limit) s++;
            else e--;
        }
        for(int el: arr){
            if(el!=-1) count++;
        }
        return count;
    }
}