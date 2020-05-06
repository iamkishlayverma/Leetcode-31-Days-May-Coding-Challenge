class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int i, maj_index = 0, count = 1;
        for (i=0; i<len; i++) {
            if (nums[maj_index] == nums[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return nums[maj_index];
    }
}
