

class Solution {
    private int k;

    // Topological sort function
    private int[] topologicalSort(int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k + 1];
        for (int[] cond : conditions) {
            int from = cond[0], to = cond[1];
            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[k];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int nei : graph.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) queue.offer(nei);
            }
        }

        if (index != k) return new int[0]; // cycle detected
        return order;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        int[] rowOrder = topologicalSort(rowConditions);
        int[] colOrder = topologicalSort(colConditions);

        if (rowOrder.length == 0 || colOrder.length == 0) return new int[0][0];

        int[][] matrix = new int[k][k];
        int[] pos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            pos[colOrder[i]] = i;
        }

        for (int i = 0; i < k; i++) {
            matrix[i][pos[rowOrder[i]]] = rowOrder[i];
        }
        return matrix;
    }
}
