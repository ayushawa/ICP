class Solution {
    public int minimumOperations(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> evencount  = new HashMap<>();
        HashMap<Integer,Integer> oddcount =  new HashMap<>();
        for(int i=0;i<n;i++){
            if(i%2 == 0 ){
                evencount.put(nums[i],evencount.getOrDefault(nums[i],0)+1);
            }
            else{
                oddcount.put(nums[i],oddcount.getOrDefault(nums[i],0)+1);
            }
        }

        int maxfreq = 0;
        int secondmax = 0;
        int maxvalue1 = 0;
        for(int key : evencount.keySet()){
            if(evencount.get(key)>maxfreq){
                secondmax = maxfreq;
                maxfreq = evencount.get(key);
                maxvalue1 = key;
            }
            else if(evencount.get(key)>secondmax){
                secondmax = evencount.get(key);
            }
        }
        int maxfreq2 = 0;
        int secondmax2 = 0;
        int maxvalue2= 0;
        for(int key : oddcount.keySet()){
            if(oddcount.get(key)>maxfreq2){
                secondmax2 = maxfreq2;
                maxfreq2 = oddcount.get(key);
                maxvalue2 = key;
            }
            else if(oddcount.get(key)>secondmax2){
                secondmax2 = oddcount.get(key);
            }
        }

        int even = (n+1)/2;
        int odd = n/2;

        if(maxvalue1 != maxvalue2) return even - maxfreq + odd - maxfreq2;

        return Math.min(even-maxfreq + odd - secondmax2,even-secondmax + odd-maxfreq2);


    }
}