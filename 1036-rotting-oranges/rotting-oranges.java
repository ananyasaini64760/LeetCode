class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        
        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++){
                int orangePos[] = queue.poll();
                int r = orangePos[0];
                int c = orangePos[1];

                for(int[] direction : directions){
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if(newRow>=0 && newRow < row && newCol>=0 && newCol < col && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        fresh--;
                        isRotten = true;
                    }
                }
            }
            if(isRotten){
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}