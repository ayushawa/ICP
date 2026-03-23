class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        for(int i =0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int first = 0;
                int last = nums4.length-1;
                while(first<nums3.length && last >=0){
                    int sum = nums1[i] + nums2[j] +nums3[first]+nums4[last];
                    if(sum == 0){
                        
                        first++;
                        last--;
                        int one = 1;
                        while(first<nums3.length && nums3[first]==nums3[first-1]){
                             one++;
                             first++;
                        }
                        int two = 1;
                        while(last>=0 && nums4[last] == nums4[last+1]) {
                            last--;
                            two++;
                        }
                        count += one * two;
                    }
                    else if(sum >0) last--;
                    else first++;
                }
            }
        }
        return count;

    }
}