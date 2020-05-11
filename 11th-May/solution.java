class Solution {
    public void floodFillUtil(int[][] image, int sr, int sc, int imageRows, int imageCols, int newColor, int originalColor) {
        if (sr >= imageRows || sr < 0 || sc >= imageCols || sc < 0) {
            return;
        }
        if (image[sr][sc] != originalColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFillUtil(image, sr-1, sc, imageRows, imageCols, newColor, originalColor);
        floodFillUtil(image, sr, sc+1, imageRows, imageCols, newColor, originalColor);        
        floodFillUtil(image, sr+1, sc, imageRows, imageCols, newColor, originalColor);
        floodFillUtil(image, sr, sc-1, imageRows, imageCols, newColor, originalColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int imageRows = image.length;
        int imageCols = image[0].length;
        int originalColor = image[sr][sc];
        if (newColor == originalColor)
            return image;
        floodFillUtil(image, sr, sc, imageRows, imageCols, newColor, originalColor);
        return image;
    }
}
