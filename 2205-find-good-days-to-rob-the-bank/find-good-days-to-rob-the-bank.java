class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int left[] = new int[n];
    
        int last = security[0];
        for(int i = 1;i<n;i++){
            if(security[i]<=last){
                left[i] = left[i-1]+1;
            }
            else left[i] = 0;
            last = security[i];
        }
        int right[]= new int[n];
        
        last = security[n-1];
        for(int i=n-2;i>=0;i--){
            if(security[i]<=last){
                right[i] = right[i+1]+1;
            }
            else right[i] = 0;
            last = security[i];
        }

        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(left[i]>=time && right[i]>=time) l.add(i);
        }
        return l;
    }
}