class Solution {
    public int kadanes(int arr[]) {
        int n = arr.length;
        int i;
        int max_so_far = arr[0];
        int max_ending_here = arr[0];
        for (i=1; i<n; i++) {
            max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        int i;
        int maxValueNonCircular = kadanes(A);
        if (maxValueNonCircular < 0)
            return maxValueNonCircular;
        int arrSum = 0;
        for (i=0; i<len; i++) {
            arrSum += A[i];
            A[i] = -A[i];
        }
        int maxValueCircular = arrSum + kadanes(A);
        int res = Math.max(maxValueNonCircular, maxValueCircular);
        return res;
    }
}
