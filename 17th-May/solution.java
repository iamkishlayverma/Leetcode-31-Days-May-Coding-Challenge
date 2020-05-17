class Solution {
    public boolean pEqualsS(char pArr[], char sArr[]) { 
        int i;
        for (i=0; i<256; i++) 
            if (pArr[i] != sArr[i]) 
                return false; 
        return true; 
    } 
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if (plen > slen)
            return res;
        char pArr[] = new char[256];
        char sArr[] = new char[256];
        int i;
        for (i=0; i<plen; i++) {
            pArr[p.charAt(i)]++;
            sArr[s.charAt(i)]++;
        }
        for (i=plen; i<slen; i++) {
            if (pEqualsS(pArr, sArr))
                res.add(i-plen);
            sArr[s.charAt(i)]++;
            sArr[s.charAt(i-plen)]--;
        }
        if (pEqualsS(pArr, sArr))
            res.add(slen-plen);
        return res;
    }
}
