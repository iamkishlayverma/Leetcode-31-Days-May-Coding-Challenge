class Solution {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int i, j;
        int dp[][] = new int[w1+1][w2+1];
        for (i=0; i<=w1; i++)
            dp[i][0] = i;
        for (j=0; j<=w2; j++)
            dp[0][j] = j;
        for (i=1; i<=w1; i++) {
            for (j=1; j<=w2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[w1][w2];
    }
}
