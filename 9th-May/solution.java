class Solution {
    public boolean isPerfectSquare(int num) {
        long i = 1, sum = 0;
        while (sum <= num) {            
            sum += i; 
            if (sum == num)
                return true;
            i = i + 2;
        }               
        return false;
    }
}
