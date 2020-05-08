class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        if (len <= 2)
            return true;        
        //calculate slopeY  = (y2-y1) and slopeX = (x2-x1)
        int slopeY = (coordinates[1][1] - coordinates[0][1]);
        int slopeX = (coordinates[1][0] - coordinates[0][0]);
        double slope = (double)slopeY/(double)slopeX;
        int i, j = 1;
        for (i=2; i<len; i++) {
            int newSlopeY = (coordinates[i][1]-coordinates[j][1]);
            int newSlopeX = (coordinates[i][0]-coordinates[j][0]);
            double newSlope = (double)newSlopeY/(double)newSlopeX;
            if (newSlope != slope) {
                return false;
            }
            j++;
        }
        return true;
    }
}
