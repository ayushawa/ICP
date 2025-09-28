class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        for(int i=0;i<n;i++){
            if(colors[i%n] != colors[(i+1)%n] && colors[(i+1)%n] != colors[(i+2)%n]){
                count++;
            }
        }
        return count;
    }
}