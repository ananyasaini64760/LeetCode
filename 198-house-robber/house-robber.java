class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return robHelper(nums, 0, dp);
    }

    public int robHelper(int[] nums, int index, Integer dp[]){
        if(index >= nums.length) return 0;

        if(dp[index] != null){
            return dp[index];
        }

        int include = nums[index] + robHelper(nums, index+2, dp);
        int exclude = robHelper(nums, index+1, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }
}
























// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         Integer dp[] = new Integer[n];
//         return robHelper(nums, 0, dp);
//     }

//     public static int robHelper(int[] nums, int index, Integer dp[]){
//         if(index >= nums.length) return 0;

//         if(dp[index] != null){
//             return dp[index];
//         }

//         int include = nums[index] +robHelper(nums, index+2, dp);
//         int exclude = robHelper(nums, index + 1, dp);
//         dp[index] = Math.max(include, exclude);
//         return dp[index];
//     }
//  }