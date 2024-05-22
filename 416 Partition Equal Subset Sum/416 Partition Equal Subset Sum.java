// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/partition-equal-subset-sum/

// Video Solution: https://www.youtube.com/watch?v=X50Rknzenus

**************** Java Solution ***********************
class Solution {
   public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it's not possible to partition it into two equal sum subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // There's always a way to make up sum 0 with an empty subset

        // Process each number in the array
        for (int num : nums) {
            // Go backwards to prevent using the same element more than once
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }
}
