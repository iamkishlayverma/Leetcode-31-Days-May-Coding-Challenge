class Solution {
    public char flipBits(char ch) {
        return (ch == '1') ? '0' : '1';
    }
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        int len = binary.length();
        int i;
        String onesComplementStr = "";
        for (i=0; i<len; i++)
            onesComplementStr +=  flipBits(binary.charAt(i));
        // System.out.println("onesComplementStr: " + onesComplementStr);
        int onesComplement = Integer.parseInt(onesComplementStr, 2);
        return onesComplement;
    }
}
