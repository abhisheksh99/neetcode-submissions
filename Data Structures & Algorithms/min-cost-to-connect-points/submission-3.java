public class Solution {
    public int minCostConnectPoints(int[][] points) {
        final int INF = Integer.MAX_VALUE;
        int n = points.length;

        // Distance array holds the min distance to MST for each point
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minDist, INF);
        minDist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            int curr = -1;

            // Find the closest unvisited point to MST
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (curr == -1 || minDist[j] < minDist[curr])) {
                    curr = j;
                }
            }

            totalCost += minDist[curr];
            visited[curr] = true;

            // Update minDist for remaining points to MST
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[curr][0] - points[j][0]) + Math.abs(points[curr][1] - points[j][1]);
                    if (dist < minDist[j]) {
                        minDist[j] = dist;
                    }
                }
            }
        }
        return totalCost;
    }
}
