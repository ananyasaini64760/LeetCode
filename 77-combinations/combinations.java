class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> small = new ArrayList<>();
        List<List<Integer>> big = new ArrayList<>();

        helper(1, n, k, small, big);
        return big;
    }

    void helper(int start, int n, int k, List<Integer>small, List<List<Integer>>big){
        if(small.size() == k){
            big.add(new ArrayList<>(small));
        }
        for(int i = start; i <= n; i++){
            small.add(i);
            helper(i+1, n, k, small, big);
            small.remove(small.size()-1);
        }
    }
}