class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sqrMatrix[][] = new int[m][n];
        int i, j, count = 0;
        for (i=0; i<m; i++) {
            for (j=0; j<n; j++) {
                if (i == 0 || j == 0)
                    sqrMatrix[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1)
                    sqrMatrix[i][j] = 1 + Math.min(sqrMatrix[i-1][j-1], Math.min(sqrMatrix[i][j-1], sqrMatrix[i-1][j]));
                else 
                    sqrMatrix[i][j] = 0;
                count = count + sqrMatrix[i][j];
            }
        }
        return count;
    }
}
