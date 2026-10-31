

class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;
        
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return false;
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootB] < rank[rootA]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4]; // [u, v, weight, index]
        for (int i = 0; i < m; ++i) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, Comparator.comparingInt(a -> a[2]));
        int originalWeight = mst(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            // Check if edge is critical: exclude it and see if MST weight increases or fails
            if (mst(n, newEdges, i, -1) > originalWeight) {
                critical.add(newEdges[i][3]);
            } 
            // Check if edge is pseudo-critical: force include edge and see if MST weight == original
            else if (mst(n, newEdges, -1, i) == originalWeight) {
                pseudoCritical.add(newEdges[i][3]);
            }
        }
        return Arrays.asList(critical, pseudoCritical);
    }

    // Calculate MST weight with optional exclude and include edges
    private int mst(int n, int[][] edges, int excludeEdge, int includeEdge) {
        DisjointSet ds = new DisjointSet(n);
        int weight = 0;

        // If including an edge forcibly
        if (includeEdge != -1) {
            ds.union(edges[includeEdge][0], edges[includeEdge][1]);
            weight += edges[includeEdge][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == excludeEdge) continue; // skip excluded edge
            if (i == includeEdge) continue; // already included

            if (ds.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
            }
        }

        // Check if all nodes connected
        int root = ds.find(0);
        for (int i = 1; i < n; i++) {
            if (ds.find(i) != root) return Integer.MAX_VALUE;
        }
        return weight;
    }
}
