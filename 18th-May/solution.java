class Solution {
    public boolean pEqualsS(char s1Arr[], char s2Arr[]) { 
        int i;
        for (i=0; i<256; i++) 
            if (s1Arr[i] != s2Arr[i]) 
                return false; 
        return true; 
    }
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        if (s1len > s2len)
            return false;
        char s1Arr[] = new char[256];
        char s2Arr[] = new char[256];
        int i;
        for (i=0; i<s1len; i++) {
            s1Arr[s1.charAt(i)]++;
            s2Arr[s2.charAt(i)]++;
        }
        for (i=s1len; i<s2len; i++) {
            if (pEqualsS(s1Arr, s2Arr))
                return true;
            s2Arr[s2.charAt(i)]++;
            s2Arr[s2.charAt(i-s1len)]--;
        }
        if (pEqualsS(s1Arr, s2Arr))
            return true;
        return false;
    }
}
