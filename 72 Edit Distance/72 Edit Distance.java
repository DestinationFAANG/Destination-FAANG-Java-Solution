
// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/edit-distance/

// Video Solution: https://www.youtube.com/watch?v=fnWskW9xaw4


**************** Java Solution ***********************

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D dp array
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp[i][0] = i and dp[0][j] = j
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }

        // Return the result
        return dp[m][n];
    }
}
