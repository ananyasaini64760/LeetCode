class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> bigList = new ArrayList<>();

        helper(nums, smallList, bigList, isVisited);
        return bigList;
    }

    void helper(int[] nums, List<Integer> smallList, List<List<Integer>> bigList, boolean[] isVisited){
        //Base Case
        if(smallList.size() == nums.length && !bigList.contains(smallList)){
            bigList.add(new ArrayList<>(smallList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!isVisited[i]){
                smallList.add(nums[i]);
                isVisited[i] = true;
                helper(nums, smallList, bigList, isVisited);
                //BackTrack
                smallList.remove(smallList.size()-1);
                isVisited[i] =false;
            }
        }
    }
}