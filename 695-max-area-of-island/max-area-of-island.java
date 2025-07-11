class Solution {
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        int[] curr = new int[1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    curr[0] = 0;
                    dfs(grid, i, j, curr);
                }
            }
        }
        return max;
    }
    void dfs(int[][] grid, int i, int j, int[] curr){
        if(i<0 || i >= grid.length || j<0 || j>= grid[0].length){
            return;
        }
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            curr[0]++;
            max = Math.max(max, curr[0]);
            dfs(grid, i+1, j, curr);
            dfs(grid, i-1, j, curr);
            dfs(grid, i, j+1, curr);
            dfs(grid, i, j-1, curr);
        }    
        else return;
    }
}