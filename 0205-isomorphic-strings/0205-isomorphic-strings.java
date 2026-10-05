class Solution {
     static boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (m1[a] != m2[b]) return false;
            m1[a] = m2[b] = i + 1;
        }
        return true;
    }
}