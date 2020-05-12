class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len-1;
        int mid = 0;
        while (l < r) {
            mid = l + (r-l)/2;
            if (l == r-1) {
                if (l == 0) {
                    mid = l;
                } else if (r == len-1) {
                    mid = r;                    
                }
                break;
            }          
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                break;
            if (mid%2 == 0) {
                if (nums[mid] == nums[mid-1]) {
                    r = mid;
                } else if (nums[mid] == nums[mid+1]) {
                    l = mid;
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    l = mid;
                } else if (nums[mid] == nums[mid+1]) {
                    r = mid;
                }
            }
        }
        return nums[mid];
    }
}
