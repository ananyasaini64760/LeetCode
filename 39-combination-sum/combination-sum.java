class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> small = new ArrayList<>();
        List<List<Integer>> big = new ArrayList<>();

        helper(candidates, target, 0, small, big);
        return big;
    }

    void helper(int[] nums, int target, int index, List<Integer> small, List<List<Integer>> big){
        if(target == 0){
            big.add(new ArrayList<Integer>(small));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index; i < nums.length; i++){
            small.add(nums[i]);
            helper(nums, target - nums[i], i, small, big);
            small.remove(small.size()-1);
        }
    }
}