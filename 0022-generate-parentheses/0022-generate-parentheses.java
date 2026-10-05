class Solution {
     static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParen(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    static void genParen(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) { res.add(cur.toString()); return; }
        if (open < n) { cur.append('('); genParen(res, cur, open + 1, close, n); cur.deleteCharAt(cur.length() - 1); }
        if (close < open) { cur.append(')'); genParen(res, cur, open, close + 1, n); cur.deleteCharAt(cur.length() - 1); }
    }
}