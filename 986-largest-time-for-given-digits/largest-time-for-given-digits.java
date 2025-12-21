class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(i == j || j ==k || i == k) continue;
                    
                    int hr = arr[i]*10+ arr[j];
                    int mn = arr[k]*10+ arr[6-i-j-k];
                 
                    if(hr<24 && mn <60){
                        String time = String.format("%02d:%02d", hr, mn);
                        if(time.compareTo(ans)>0){
                            ans = time;
                        }
                    }
                }
            }
        }
        return ans;
    }
}