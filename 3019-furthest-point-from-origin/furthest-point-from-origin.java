class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int x = 0;
        for(int i = 0;i<moves.length();i++){
            char ch = moves.charAt(i);
            if(ch == 'L') x--;
            else if(ch == 'R') x++;
            else x--;
        }

        int ans = Math.abs(x);
        x = 0;
        for(int i = 0;i<moves.length();i++){
            char ch = moves.charAt(i);
            if(ch == 'L') x--;
            else if(ch == 'R') x++;
            else x++;
        }
        ans = Math.max(ans,Math.abs(x));
        return ans;
    }
}