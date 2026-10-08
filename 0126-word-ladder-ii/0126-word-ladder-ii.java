class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<>();

        Set<String> current = new HashSet<>();
        current.add(beginWord);

        boolean found = false;

        while (!current.isEmpty() && !found) {

            words.removeAll(current);

            Set<String> next = new HashSet<>();

            for (String word : current) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        chars[i] = ch;

                        String newWord = new String(chars);

                        if (words.contains(newWord)) {

                            next.add(newWord);

                            graph.computeIfAbsent(
                                newWord,
                                k -> new ArrayList<>()
                            ).add(word);

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[i] = original;
                }
            }

            current = next;
        }

        if (found) {

            List<String> path = new ArrayList<>();

            path.add(endWord);

            backtrack(endWord, beginWord, graph, path, result);
        }

        return result;
    }

    private void backtrack(
            String word,
            String beginWord,
            Map<String, List<String>> graph,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);

            Collections.reverse(temp);

            result.add(temp);

            return;
        }

        if (!graph.containsKey(word)) {
            return;
        }

        for (String previous : graph.get(word)) {

            path.add(previous);

            backtrack(
                previous,
                beginWord,
                graph,
                path,
                result
            );

            path.remove(path.size() - 1);
        }
    }
}