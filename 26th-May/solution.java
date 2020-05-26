class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int i;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int sum = 0, res = 0;
        for (i=0; i<len; i++) {
            if (nums[i] == 0)
                sum += -1;
            else
                sum += 1;
            if (hmap.containsKey(sum))
                res = Math.max(res, i-hmap.get(sum));
            else
                hmap.put(sum, i);
        }
        return res;
    }
}
