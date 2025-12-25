class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[]  map =new ArrayList[101];
        for(int i=0;i<101;i++) map[i] = new ArrayList<>();

        for(int k[] : rectangles){
            map[k[1]].add(k[0]);
        }

        for(int i=1;i<101;i++){
           Collections.sort(map[i]);
        }

        
        int ans[] = new int[points.length];
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;

            for(int k = y;k<=100;k++){
                List<Integer> lis = map[k];

                int ind = Collections.binarySearch(lis,x);
                if(ind<0) ind = -(int)ind -1;

                count+= lis.size()-ind;
            }
            ans[i] = count;
        }
        return ans;
        
    }
}