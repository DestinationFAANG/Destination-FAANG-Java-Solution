// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/redundant-connection/

// Video Solution: https://www.youtube.com/watch?v=ctMC5TPuVnM

**************** Java Solution ***********************

class Solution {
     public static int[] findRedundantConnection(int[][] edges) {
        // Initialize the parent array where parent[i] represents the parent of node i
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i; // Initially, each node is its own parent
        }

        // Iterate through the edges to find the redundant one
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            // Find the roots of node1 and node2
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            // If the roots are the same, a cycle is detected, return the current edge
            if (root1 == root2) {
                return edge;
            }

            // Union the sets by making root1 the parent of root2
            parent[root2] = root1;
        }

        // If no cycle is found (which should not happen in this problem), return an empty array
        return new int[0];
    }

    // Helper function to find the root of a node
    private static int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]]; // Path compression for optimization
            node = parent[node];
        }
        return node;
    }
}
