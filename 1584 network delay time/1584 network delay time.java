// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/network-delay-time/

// Video Solution: https://www.youtube.com/watch?v=QKRRjz4KMuE

**************** Java Solution ***********************

class Solution {
   public int networkDelayTime(int[][] times, int n, int k) {
        // Create a graph represented as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // Use a priority queue to select the node with the minimum distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Start from node k with a distance of 0

        // Initialize distances array with infinity
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0; // Distance to itself is 0

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            // If we have already found a shorter path before, continue
            if (currentDist > distances[currentNode]) {
                continue;
            }

            // Update the distances of neighboring nodes
            if (graph.containsKey(currentNode)) {
                for (int[] neighbor : graph.get(currentNode)) {
                    int nextNode = neighbor[0];
                    int nextDist = currentDist + neighbor[1];
                    if (nextDist < distances[nextNode]) {
                        distances[nextNode] = nextDist;
                        pq.offer(new int[]{nextNode, nextDist});
                    }
                }
            }
        }

        // Find the maximum distance from the source node to all other nodes
        int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }

}
