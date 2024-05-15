// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/min-cost-climbing-stairs/

// Video Solution: https://www.youtube.com/watch?v=A3LYMRqAQeU

**************** Java Solution ***********************

class Solution {
   public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int current = Math.min(first, second) + cost[i];
            first = second;
            second = current;
        }
        
        // Minimum cost to reach the last step or one step past it
        return Math.min(first, second);
    }
}
