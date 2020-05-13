class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k)
            return "0";
        StringBuilder str = new StringBuilder();
        str.append(num);
        int i = 0, j;
        while (i < k) {
            for (j=0; j<str.length()-1; j++) {
                if (str.charAt(j) > str.charAt(j+1))
                    break;
            }
            str.delete(j, j+1);
            i++;
        }
        while (str.length() > 1 && str.charAt(0) == '0')
            str.delete(0, 1);
        return str.toString();
    }
}
