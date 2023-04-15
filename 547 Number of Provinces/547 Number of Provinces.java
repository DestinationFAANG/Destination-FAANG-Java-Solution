Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

Leetcode Link:https://leetcode.com/problems/number-of-provinces/

Video Solution: https://www.youtube.com/watch?v=ff38kbREIX8

**************** Java Solution ***********************


class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[city][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }


}
