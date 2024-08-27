// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/partition-labels/

// Video Solution: https://www.youtube.com/watch?v=TvWEYhHPO0w

**************** Java Solution ***********************
class Solution {
   
    public List<Integer> partitionLabels(String s) {
        // Step 1: Store the last occurrence of each character
        int[] lastOccurrence = new int[26]; // Since the input is lowercase English letters
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Iterate through the string to determine partitions
        List<Integer> result = new ArrayList<>();
        int partitionEnd = 0;
        int partitionStart = 0;

        for (int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);

            // When we reach the end of the current partition
            if (i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = i + 1; // Move to the next partition
            }
        }

        return result;
    }
    
    
}
