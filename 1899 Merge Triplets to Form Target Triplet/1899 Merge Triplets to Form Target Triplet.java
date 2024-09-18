
// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/

// Video Solution: https://www.youtube.com/watch?v=OVjB6kGr29g


**************** Java Solution ***********************

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Initialize the max values for each element in the triplet
        int[] maxValues = new int[3];

        // Iterate over each triplet
        for (int[] triplet : triplets) {
            // Check if the current triplet can contribute to the target
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                // Update the max values for each element
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }

        // Check if the max values match the target triplet
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }

}
