// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/coin-change-ii/

// Video Solution: https://www.youtube.com/watch?v=khIBdTrRggk

**************** Java Solution ***********************

class Solution {
     public int change(int amount, int[] coins) {
        // dp array to store the number of ways to make each amount
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // There is one way to make the amount 0: use no coins

        // Update the dp array for each coin
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        // The answer for the original amount
        return dp[amount];
    }
}
