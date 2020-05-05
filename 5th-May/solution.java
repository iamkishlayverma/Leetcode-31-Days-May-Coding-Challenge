class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0)
            return -1;
        int i;
        int firstUnique[] = new int[256];
        for (i=0; i<256; i++)
            firstUnique[i] = -1;
        for (i=0; i<len; i++) {
            if (firstUnique[s.charAt(i)] == -1)
                firstUnique[s.charAt(i)] = i;
            else
                firstUnique[s.charAt(i)] = -2;
        }
        int res = Integer.MAX_VALUE;
        for (i=0; i<256; i++) {
            if (firstUnique[i] >= 0) {
                res = Math.min(res, firstUnique[i]);
            }
        }
        if (res != Integer.MAX_VALUE)
            return res;
        else
            return -1;
    }
}
