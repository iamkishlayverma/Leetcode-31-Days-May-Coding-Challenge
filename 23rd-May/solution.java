class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA = A.length;
        int lenB = B.length;
        int i = 0, j = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i<lenA && j<lenB) {
            int maxValInFirstElements = Math.max(A[i][0], B[j][0]);
            int minValInSecondElements = Math.min(A[i][1], B[j][1]);
            if (minValInSecondElements >= maxValInFirstElements) {
                int[] arr = new int[2];
                arr[0] = maxValInFirstElements;
                arr[1] = minValInSecondElements;
                res.add(arr);
            }
            if (A[i][1] == minValInSecondElements)
                i++;
            if (B[j][1] == minValInSecondElements)
                j++;
        }
        int finalArr[][] = new int[res.size()][2];
		return res.toArray(finalArr);
    }
}
