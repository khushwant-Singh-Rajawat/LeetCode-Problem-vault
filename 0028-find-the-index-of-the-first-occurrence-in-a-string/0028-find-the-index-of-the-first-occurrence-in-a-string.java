class Solution {
   static int strStr(String haystack, String needle) {
        for (int i = 0; i + needle.length() <= haystack.length(); i++)
            if (haystack.startsWith(needle, i)) return i;
        return -1;
    }
}