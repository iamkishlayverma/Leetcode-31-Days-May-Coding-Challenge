/*NOT OPTIMIZED SOLUTION*/
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA = A.length;
        int lenB = B.length;
        int i, j = 0, k = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (i=0; i<lenA; i++) {
            for (j=0; j<lenB; j++) {
                if ((A[i][1] >= B[j][0] && A[i][1] <= B[j][1]) || (A[i][0] >= B[j][0] && A[i][0] <= B[j][1])
                  || (A[i][0] <= B[j][0] && A[i][1] >= B[j][1]) || (A[i][0] >= B[j][0] && A[i][1] <= B[j][1])) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    int first = (A[i][0] <= B[j][0]) ? B[j][0] : A[i][0];
                    int second = (A[i][1] <= B[j][1]) ? A[i][1] : B[j][1];
                    arr.add(first);
                    arr.add(second);
                    res.add(arr);
                }
            }            
        }
        int[][] array = new int[res.size()][];
		    for (i=0; i<array.length; i++) {
          array[i] = new int[res.get(i).size()];
        }
        for(i=0; i<res.size(); i++){
          for (j = 0; j < res.get(i).size(); j++) {
            array[i][j] = res.get(i).get(j);
          }
        }
        return array;
    }
}
