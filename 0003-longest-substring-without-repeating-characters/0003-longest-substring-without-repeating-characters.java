class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] last = new int[128];
        Arrays.fill(last, -1);
        int best = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (last[c] >= l) l = last[c] + 1;
            last[c] = r;
            best = Math.max(best, r - l + 1);
        }
        return best;  
    }
}