class Solution {
    public String longestPalindrome(String s) {
        int st = 0, en = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > en - st + 1) {
                st = i - (len - 1) / 2;
                en = i + len / 2;
            }
        }
        return s.substring(st, en + 1);
    }
    static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
        return r - l - 1;
    }
}
