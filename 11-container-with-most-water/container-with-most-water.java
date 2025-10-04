class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int maxi = 0;
        while(s<e){
            int area = (e-s)*Math.min(arr[s],arr[e]);
            maxi = Math.max(area,maxi);
            if(arr[e]>arr[s]) s++;
            else e--;
        }
        return maxi;
    }
}