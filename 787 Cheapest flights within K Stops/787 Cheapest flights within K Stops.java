// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/

// Video Solution: https://www.youtube.com/watch?v=AVsymWOY6fc

**************** Java Solution ***********************

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        java.util.Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = costs.clone(); // Clone the costs array to use for this iteration
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                if (costs[u] == Integer.MAX_VALUE) continue; // If the source node u is not reachable
                if (temp[v] > costs[u] + cost) {
                    temp[v] = costs[u] + cost;
                }
            }
            costs = temp;
        }
        
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
