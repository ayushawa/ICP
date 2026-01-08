class Solution {
    public int countHousePlacements(int n) {
        int a = 1;
        int b = 1;
        int c = 2;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < n; ++i) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)(1L * b * b % mod);
    }
}