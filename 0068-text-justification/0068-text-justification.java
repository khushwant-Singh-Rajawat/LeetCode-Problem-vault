class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int length = 0;

            while (j < words.length &&
                   length + words[j].length() + (j - i) <= maxWidth) {

                length += words[j].length();
                j++;
            }

            int numberOfWords = j - i;
            int spaces = maxWidth - length;

            String line = "";

            // Last line or only one word
            if (j == words.length || numberOfWords == 1) {

                for (int k = i; k < j; k++) {

                    line += words[k];

                    if (k < j - 1) {
                        line += " ";
                    }
                }

                while (line.length() < maxWidth) {
                    line += " ";
                }

            } else {

                int gaps = numberOfWords - 1;

                int spacesEach = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line += words[k];

                    if (k < j - 1) {

                        int count = spacesEach;

                        if (extra > 0) {
                            count++;
                            extra--;
                        }

                        for (int x = 0; x < count; x++) {
                            line += " ";
                        }
                    }
                }
            }

            result.add(line);

            i = j;
        }

        return result;
    }
}