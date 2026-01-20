class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;

        ArrayList<Integer>[] blocks = new ArrayList[26];
        for (int i = 0; i < 26; i++) blocks[i] = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            blocks[s.charAt(i) - 'a'].add(j - i);
            i = j;
        }

        for (int c = 0; c < 26; c++) {
            ArrayList<Integer> l = blocks[c];
            if (l.isEmpty()) continue;

            l.sort(Collections.reverseOrder());

            int L1 = l.get(0);
            int L2 = l.size() > 1 ? l.get(1) : 0;
            int L3 = l.size() > 2 ? l.get(2) : 0;

            if (L1 >= 3) ans = Math.max(ans, L1 - 2);
            if (L2 >= 1 && L1 >= 2) ans = Math.max(ans, Math.min(L1 - 1, L2));
            if (L3 >= 1) ans = Math.max(ans, L3);
        }

        return ans;
    }
}
