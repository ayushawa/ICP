class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int distcount = 0;
        int prevmaxK = -1;
        int prevminK = -1;
        int countmaxK = 0;
        int countminK = 0;
        int count = 0;
        if(minK == maxK) distcount = 1;
        else distcount= 2;
        int i = 0;
        int j=0;
        while(i<nums.length){
            if(minK<=nums[i] && nums[i]<=maxK){
                if(distcount==1){
                    if(nums[i] == minK){
                        countminK++;
                        if(countminK == 1) count++;
                        prevminK = i;
                        prevmaxK = i;
                        
                    }
                }else {
                    if(nums[i] == minK){
                        countminK++;
                        if(countminK == 1) count++;
                        prevminK = i;
                    }else if(nums[i] == maxK){
                        countmaxK++;
                        if(countmaxK == 1) count++;
                        prevmaxK = i;
                    }

                }
                
                if(count == distcount){
                    ans += Math.min(prevminK,prevmaxK) - j + 1;
                 }
            }else{
                 prevmaxK = -1;
                  prevminK = -1;
                  countmaxK = 0;
                  countminK = 0;
                  count = 0;
                  j=i+1;
            }
            i++;
        }
        return ans;
    }
}