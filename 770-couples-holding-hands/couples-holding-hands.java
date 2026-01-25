class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int index[] = new int[n];
        for(int i=0;i<n;i++){
            index[row[i]]  = i;
        }

        int count =0;
        for(int i=0;i<n;i+=2){
            int partner1 = row[i];
            int partner2;
            if(partner1%2 == 0){
                partner2 = partner1 + 1;
            }
            else partner2 = partner1-1;

            int neigh = row[i+1];
            if(neigh != partner2){
                int idx = index[partner2];

                row[i+1] = partner2;
                row[idx] = neigh;

                index[partner2] = i+1;
                index[neigh] = idx;

                count++;
            }
        }
        return count;
    }
}