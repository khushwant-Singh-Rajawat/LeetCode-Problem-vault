import java.util.*;

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        backtrack(s, 0, 0, "");

        return result;
    }

    void backtrack(String s, int index,
                   int count, String ip) {

        if (count == 4 && index == s.length()) {
            result.add(ip.substring(0, ip.length() - 1));
            return;
        }

        if (count == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            if (num > 255) break;

            backtrack(s, index + len,
                      count + 1, ip + part + ".");
        }
    }
}