public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all treasure cells (value 0)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0], col = point[1];

                for (int[] dir : directions) {
                    int r = row + dir[0], c = col + dir[1];
                    // Skip out of bounds, walls, or already updated cells
                    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == -1 || grid[r][c] != Integer.MAX_VALUE) continue;
                    grid[r][c] = distance;
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }
}
