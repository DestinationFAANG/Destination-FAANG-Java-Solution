// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/rotting-oranges/

// Video Solution: https://www.youtube.com/watch?v=1BlwbFfgk-E

**************** Java Solution ***********************

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        // Count fresh oranges and enqueue rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4-directional

        // BFS
        while (!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = rottenQueue.poll();
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Turn fresh orange to rotten
                        freshCount--;
                        rottenQueue.offer(new int[]{x, y});
                    }
                }
            }
            minutes++; // Increment timer after each level of BFS
        }

        return freshCount == 0 ? minutes - 1 : -1; // Adjust for extra increment
    }
}

