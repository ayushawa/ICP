class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;

        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        if (maxVal >= 0) isPrime[0] = false;
        if (maxVal >= 1) isPrime[1] = false;
        for (int i = 2; i * i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (isPrime[nums[i]] ? 1 : 0);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int r = 0;
        long ans = 0;

        for (int l = 0; l < n; l++) {
            while (r < n) {
                if (isPrime[nums[r]]) {
                    map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                }

                if (!map.isEmpty() && map.lastKey() - map.firstKey() > k) {
                    if (isPrime[nums[r]]) {
                        int c = map.get(nums[r]);
                        if (c == 1) map.remove(nums[r]);
                        else map.put(nums[r], c - 1);
                    }
                    break;
                }
                r++;
            }

            int need = pref[l] + 2;
            int lo = 0, hi = pref.length;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (pref[mid] >= need) hi = mid;
                else lo = mid + 1;
            }
            if (lo < pref.length && lo <= r) {
                ans += (r - lo + 1);
            }

            if (isPrime[nums[l]]) {
                int c = map.get(nums[l]);
                if (c == 1) map.remove(nums[l]);
                else map.put(nums[l], c - 1);
            }
        }

        return (int) ans;
    }
}
