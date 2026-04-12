
class Solution {

    int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int[] dp = new int[26];

        for (int i = 1; i < word.length(); i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            int[] newDp = new int[26];
            Arrays.fill(newDp, Integer.MAX_VALUE);

            for (int j = 0; j < 26; j++) {
                newDp[j] = Math.min(newDp[j], dp[j] + dist(prev, curr));
                newDp[prev] = Math.min(newDp[prev], dp[j] + dist(j, curr));
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int x : dp) ans = Math.min(ans, x);

        return ans;
    }
}