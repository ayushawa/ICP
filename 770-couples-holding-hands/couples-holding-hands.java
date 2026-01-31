class Solution {
    public int minSwapsCouples(int[] nums) {
        int n= nums.length;
        int position[] = new int[n];
        for(int i=0;i<n;i++){
            position[nums[i]] = i;
        }
       
        int count =0;
        for(int i=0;i<n;i+=2){
            int partner1 = nums[i];
            int partner2 ;
            if(partner1%2 == 0){
                partner2 = partner1 + 1;
            }
            else partner2 = partner1-1;

            int neigh = nums[i+1];
            if(partner2 != neigh){
                int idx = position[partner2];
                nums[i+1] = partner2;
                nums[idx] = neigh;

                position[partner2] = i+1;
                position[neigh] = idx; 
                count++;
            }
        }
        return count;
    }
}