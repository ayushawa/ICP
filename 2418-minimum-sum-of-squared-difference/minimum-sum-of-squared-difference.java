class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int maxD = 0;
        int[] cnt = new int[100001];

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            cnt[d]++;
            maxD = Math.max(maxD, d);
        }

        for (int d = maxD; d > 0 && k > 0; d--) {
            if (cnt[d] == 0) continue;

            long use = Math.min(k, cnt[d]);
            cnt[d] -= use;
            cnt[d - 1] += use;
            k -= use;
        }

        long ans = 0;
        for (int d = 0; d <= maxD; d++) {
            if (cnt[d] > 0) {
                ans += (long) d * d * cnt[d];
            }
        }
        return ans;
    }
}


