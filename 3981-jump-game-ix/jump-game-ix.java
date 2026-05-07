class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
        }

        int[] ans = new int[n];

        int start = 0;
        int mx = nums[0];
        int compMax = nums[0];

        for (int i = 0; i < n - 1; i++) {

            mx = Math.max(mx, nums[i]);
            compMax = Math.max(compMax, nums[i]);

            if (mx <= sufMin[i + 1]) {

                for (int j = start; j <= i; j++) {
                    ans[j] = compMax;
                }

                start = i + 1;

                if (start < n) {
                    mx = nums[start];
                    compMax = nums[start];
                }
            }
        }

        compMax = nums[start];

        for (int i = start; i < n; i++) {
            compMax = Math.max(compMax, nums[i]);
        }

        for (int i = start; i < n; i++) {
            ans[i] = compMax;
        }

        return ans;
    }
}