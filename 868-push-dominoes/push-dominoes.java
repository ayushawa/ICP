class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int left[] = new int[n];
        int right[] = new int[n];
        int ind = -1;
        for(int i=0;i<n;i++){
            char ch = dominoes.charAt(i);
            if(ch == 'R') ind = i;
            else if(ch=='L') ind = -1;
            left[i] = ind;
        }
        ind = n;
        for(int i=n-1;i>=0;i--){
            char ch = dominoes.charAt(i);
            if(ch == 'L') ind = i;
            else if(ch=='R') ind = n;
            right[i] = ind;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int l =i- left[i];
            int r = right[i]-i;
            if(dominoes.charAt(i)!='.') sb.append(dominoes.charAt(i));
            else if(left[i]==-1 && right[i]==n) sb.append('.');
            else if(left[i]!= -1 && right[i]!=n && l<r ) sb.append('R');
            else if(left[i]!= -1 && right[i]!=n && l>r ) sb.append('L');
            else if(left[i]!= -1 && right[i]!=n && l==r ) sb.append('.');
            else if(left[i]==-1) sb.append('L');
            else if(right[i]==n) sb.append('R');
            else sb.append(".");
        }
        return sb.toString();
    }
}