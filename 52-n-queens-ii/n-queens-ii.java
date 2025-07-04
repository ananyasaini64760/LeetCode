class Solution {
    boolean[][] board;
    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return helper(0, n);
    }
    
    boolean willIPlaceQueen(int row, int col){
        //Case 1 cant place below previous queen
        for(int i = row; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        //Case 2 Cant place diagonally to the left
        for(int i = row, j = col; i>=0 && j>=0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }
        //Case 3 Cant place diagonally to the right
        for(int i = row, j = col; i>=0 && j < board[0].length; i--, j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

    int helper(int row, int n){
        //Base Case
        if(row == n){
            return 1;
        }
        int count = 0;
        for(int col = 0; col < n; col++){
            if(willIPlaceQueen(row, col)){
                board[row][col] = true;
                count = count + helper(row+1, n);
                //BackTrack
                board[row][col] = false;
            }
        }
        return count;
    }
}