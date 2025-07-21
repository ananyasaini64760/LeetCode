class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}














//class Solution {
//     int helper(int[] cost, int i){
//         if(i == 0 || i == 1){
//             return cost[i];
//         }
//         return cost[i] + Math.min(helper(cost, i-1), helper(cost, i-2));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return Math.min(helper(cost, n-1), helper(cost, n-2));
//     }
// }