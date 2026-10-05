class Solution {
     static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackPhone(digits, 0, new StringBuilder(), map, res);
        return res;
    }
    static void backtrackPhone(String d, int i, StringBuilder cur, String[] map, List<String> res) {
        if (i == d.length()) { res.add(cur.toString()); return; }
        for (char c : map[d.charAt(i) - '0'].toCharArray()) {
            cur.append(c);
            backtrackPhone(d, i + 1, cur, map, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}