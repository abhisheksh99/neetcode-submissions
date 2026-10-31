public class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build graph with lexical order priority queue for destinations
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK");
        return itinerary;
    }

    private void dfs(String airport) {
        PriorityQueue<String> nextDestinations = graph.get(airport);
        while (nextDestinations != null && !nextDestinations.isEmpty()) {
            dfs(nextDestinations.poll());
        }
        itinerary.addFirst(airport);
    }
}