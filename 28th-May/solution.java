class Solution {
    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0, 1};
        int res[] = new int[num+1];
        res[0] = 0;
        res[1] = 1;
        int i, currVal = 1;
        for (i=2; i<=num; i++) {
            if (currVal == (i - currVal)) {
                currVal = i;
                res[i] = 1;
            } else {
                res[i] = res[currVal] + res[i - currVal];
            }
        }
        return res;
    }
}
