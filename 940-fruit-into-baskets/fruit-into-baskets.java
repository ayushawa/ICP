class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int j=0;
        int maxiCount = 0;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>2){
                map.put(arr[j],map.get(arr[j])-1);
                if(map.get(arr[j]) == 0) map.remove(arr[j]);
                j++;
            }
            maxiCount = Math.max(maxiCount,i-j+1);
        }
        return maxiCount;
    }
}