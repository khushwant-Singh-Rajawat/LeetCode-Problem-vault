class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) { int t = max; max = min; min = t; }
            max = Math.max(x, max * x);
            min = Math.min(x, min * x);
            res = Math.max(res, max);
        }
        return res;
    }
}