class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> bigList = new ArrayList<>();
        helper(nums, 0, smallList, bigList);
        return bigList;
    }

    void helper(int[] nums, int index, List<Integer> smallList, List<List<Integer>> bigList){
        //Base Case
        if(index > nums.length){
            return;
        }
        bigList.add(new ArrayList<>(smallList));
        for(int i = index; i < nums.length; i++){
            
            smallList.add(nums[i]);
            helper(nums, i+1, smallList, bigList);
            smallList.remove(smallList.size()-1);
            
        }
    }
}