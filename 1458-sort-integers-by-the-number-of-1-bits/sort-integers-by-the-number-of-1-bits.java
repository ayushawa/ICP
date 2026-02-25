class Solution {
    public int[] sortByBits(int[] arr) {
        Integer temp[] = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp,(a,b)->Integer.bitCount(a)!=Integer.bitCount(b)?Integer.compare(Integer.bitCount(a),Integer.bitCount(b)):Integer.compare(a,b));

        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
}