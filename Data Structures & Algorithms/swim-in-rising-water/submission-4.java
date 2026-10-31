class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[][] grid, int time) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0, 0, time);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int time) {
        int n = grid.length;

        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > time) {
            return false;
        }

        if (i == n - 1 && j == n - 1) {
            return true;
        }

        visited[i][j] = true;

        // Move up, down, left, right using direct calls
        return dfs(grid, visited, i + 1, j, time) ||
               dfs(grid, visited, i - 1, j, time) ||
               dfs(grid, visited, i, j + 1, time) ||
               dfs(grid, visited, i, j - 1, time);
    }
}
