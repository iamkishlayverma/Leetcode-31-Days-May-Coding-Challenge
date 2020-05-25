class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int i, j;
        int dp[][] = new int[lenA + 1][lenB + 1];
        for (i=0; i<=lenA; i++) {
            for (j=0; j<=lenB; j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else if (A[i-1] == B[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[lenA][lenB];
    }
}
