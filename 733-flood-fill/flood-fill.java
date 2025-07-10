class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if(currColor == color){
            return image;
        }
        dfs(image, sr, sc, color, currColor);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int newColor, int currColor){
        if(sr<0 || sr >= image.length || sc<0 || sc >= image[0].length || image[sr][sc] != currColor){
            return;
        }
        image[sr][sc] = newColor;

        dfs(image, sr+1, sc, newColor, currColor);
        dfs(image, sr-1, sc, newColor, currColor);
        dfs(image, sr, sc+1, newColor, currColor);
        dfs(image, sr, sc-1, newColor, currColor);
    }
}