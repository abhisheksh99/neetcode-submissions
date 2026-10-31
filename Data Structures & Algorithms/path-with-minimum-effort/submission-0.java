class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {effort, x, y}

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEff = curr[0], x = curr[1], y = curr[2];

            if (x == m - 1 && y == n - 1) return currEff;

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextEff = Math.max(currEff, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (nextEff < effort[nx][ny]) {
                        effort[nx][ny] = nextEff;
                        pq.offer(new int[]{nextEff, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}