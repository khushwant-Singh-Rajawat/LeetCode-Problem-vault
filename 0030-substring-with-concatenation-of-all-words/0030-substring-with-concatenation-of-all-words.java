import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int len = words[0].length();
        int count = words.length;

        int total = len * count;

        if (n < total) return ans;

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Check each possible word alignment
        for (int i = 0; i < len; i++) {

            int left = i;
            int right = i;
            int matched = 0;

            Map<String, Integer> seen = new HashMap<>();

            while (right + len <= n) {

                String word = s.substring(right, right + len);

                right += len;

                if (!map.containsKey(word)) {

                    seen.clear();
                    matched = 0;
                    left = right;

                } else {

                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    matched++;

                    while (seen.get(word) > map.get(word)) {

                        String leftWord = s.substring(left, left + len);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += len;
                        matched--;
                    }

                    if (matched == count) {

                        ans.add(left);

                        String leftWord = s.substring(left, left + len);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += len;
                        matched--;
                    }
                }
            }
        }

        return ans;
    }
}