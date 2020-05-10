class Solution {
    public int findJudge(int N, int[][] trust) {
        int i, res = -1;
        int arr[] = new int[N+1];
        int len = trust.length;
        for (i=0; i<len; i++) {
            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }
        for (i=1; i<=N; i++) {
            if (arr[i] == N-1)
                res = i;
        }
        return res;
    }
}
