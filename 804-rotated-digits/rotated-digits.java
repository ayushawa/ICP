class Solution {
    public int rotatedDigits(int n) {
        int count =0;
        for(int i =1;i<=n;i++){
            int val = i;
            boolean valid = true;
            boolean diff = false;
            while(val > 0){
                int mod = val%10;
                if(mod == 3 || mod == 4 || mod == 7){
                    valid = false;
                    break;
                }
                if(mod == 2 || mod == 5 || mod == 6 || mod == 9) diff = true;
                val = val/10;
            }
            if(valid && diff ) count++;
        }
        return count;
    }
}