class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rl = ransomNote.length();
        int ml = magazine.length();
        int randomArr[] = new int[123];
        int magazineArr[] = new int[123];
        int i, j;
        for (i=0; i<rl; i++) {
            int asciiValue = ransomNote.charAt(i);
            randomArr[asciiValue]++;
        }
        for (i=0; i<ml; i++) {
            int asciiValue = magazine.charAt(i);
            magazineArr[asciiValue]++;
        }
        for (i=97; i<123; i++) {
            if (randomArr[i] != 0 && randomArr[i] > magazineArr[i]) {
                return false;
            }
        }
        return true;
    }
}
