// Most asked intervie qusetions: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit?gid=1377915986#gid=1377915986
// Leetcode link: https://leetcode.com/problems/burst-balloons/
// Video solution: https://www.youtube.com/watch?v=TfvN6rqDOT0



class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;
        
        // Copy the original nums array into extendedNums
        for (int i = 1; i <= n; i++) {
            extendedNums[i] = nums[i - 1];
        }
        
        // DP table to store maximum coins
        int[][] dp = new int[n + 2][n + 2];
        
        // Fill the DP table
        for (int length = 1; length <= n; length++) {  // Length of subarray
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                
                // Try every position as the last balloon to burst in this range
                for (int i = left; i <= right; i++) {
                    int coins = extendedNums[left - 1] * extendedNums[i] * extendedNums[right + 1];
                    coins += dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        
        // The result is the maximum coins obtained by bursting all balloons
        return dp[1][n];
    }
}
