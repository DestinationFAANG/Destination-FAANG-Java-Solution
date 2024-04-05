// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/reconstruct-itinerary/

// Video Solution: https://www.youtube.com/watch?v=1_bfI1mi6mA

**************** Java Solution ***********************

class Solution {
  public static List<String> findItinerary(List<List<String>> tickets) {
        // Create a map to store the list of destinations for each departure airport
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // Sort the destinations for each departure airport in lexical order
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }

        // Start the itinerary from "JFK"
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private static void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinerary) {
        List<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            // Remove the next destination to avoid revisiting the same path
            String next = destinations.remove(0);
            dfs(next, graph, itinerary);
        }
        // Add the airport to the itinerary at the beginning to build the itinerary in reverse order
        itinerary.addFirst(airport);
    }
}
