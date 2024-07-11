Most asked faang questions - https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit?gid=1377915986#gid=1377915986

Leetcode link: https://leetcode.com/problems/text-justification/

Video solution: https://www.youtube.com/watch?v=Pf_1Ox9ud_w

************** Java Solution *****************

class Solution {
     public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Determine the last word that fits on the current line
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1; // number of gaps between words

            // If this is the last line or contains only one word, left-justify
            if (last == n || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        sb.append(" ");
                    }
                }
                int remainingSpaces = maxWidth - sb.length();
                appendSpaces(sb, remainingSpaces);
            } else {
                int spaces = (maxWidth - totalChars) / diff;
                int extraSpaces = (maxWidth - totalChars) % diff;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        int spacesToApply = spaces + (i - index < extraSpaces ? 1 : 0);
                        appendSpaces(sb, spacesToApply + 1); // one space for word separation
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }

        return result;
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}
