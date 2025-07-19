class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];

            // Check floor and ceiling in TreeSet for valueDiff condition
            Long floor = set.floor(num + valueDiff);
            Long ceil = set.ceiling(num - valueDiff);

            if ((floor != null && floor >= num) || (ceil != null && ceil <= num)) {
                return true;
            }

            set.add(num);

            // Maintain sliding window size
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}