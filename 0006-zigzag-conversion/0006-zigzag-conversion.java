class Solution {
   static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int idx = 0, dir = 1;
        for (char c : s.toCharArray()) {
            rows[idx].append(c);
            if (idx == 0) dir = 1;
            else if (idx == numRows - 1) dir = -1;
            idx += dir;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder r : rows) res.append(r);
        return res.toString();
    }
}