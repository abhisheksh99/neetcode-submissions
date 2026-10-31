public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph
        Map<String, LinkedList<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
        }

        // Sort each adjacency list in reverse order to pop lex order smallest
        for (LinkedList<String> dests : graph.values()) {
            Collections.sort(dests, Collections.reverseOrder());
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, LinkedList<String>> graph, LinkedList<String> itinerary) {
        LinkedList<String> dests = graph.get(airport);
        while (dests != null && !dests.isEmpty()) {
            String nextDest = dests.removeLast();  // Get lex smallest destination due to reverse sort
            dfs(nextDest, graph, itinerary);
        }
        itinerary.addFirst(airport);  // Post-order addition
    }
}