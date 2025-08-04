class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        // Try all possible p and q (1 <= p < q < n-1)
        for (int p = 1; p < n - 2; p++) {
            if (!isIncreasing(nums, 0, p)) continue;

            for (int q = p + 1; q < n - 1; q++) {
                if (isDecreasing(nums, p, q) && isIncreasing(nums, q, n - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Check strictly increasing from start to end (inclusive start, exclusive end)
    private static boolean isIncreasing(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= nums[i - 1]) return false;
        }
        return true;
    }

    // Check strictly decreasing from start to end (inclusive start, exclusive end)
    private static boolean isDecreasing(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] >= nums[i - 1]) return false;
        }
        return true;
    }
}