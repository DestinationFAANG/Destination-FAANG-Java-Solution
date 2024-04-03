// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.ca/all/286.html

// Video Solution: https://www.youtube.com/watch?v=wYv60DTtsto

**************** Java Solution ***********************

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0}; // 4-directional (right, down, left, up)

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS from each gate
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for (int i = 0; i < 4; i++) { // Explore 4 directions
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                // Check boundaries and if the cell is an empty room
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
