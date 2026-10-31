class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(source, x -> new ArrayList<>()).add(new int[]{target, weight});
        }

        // Step 2: Min-heap priority queue to always select node with shortest distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{k, 0}); // {node, distance}

        // Step 3: Distance array initialized to "infinity"
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0; // Distance to start node is 0

        // Step 4: Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];

            // Skip if we have already found a shorter path
            if (dist > distance[node]) continue;

            // Update distances for neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    int newDist = dist + weight;

                    if (newDist < distance[nextNode]) {
                        distance[nextNode] = newDist;
                        minHeap.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }

        // Step 5: Get the maximum distance from start node to all other nodes
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1; // Unreachable node
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        return maxDistance;
    }
}