class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Each land cell contributes 4 sides initially
                    perimeter += 4;
                    // If there's land above, subtract 2 (shared edge counted twice)
                    if (r > 0 && grid[r - 1][c] == 1) perimeter -= 2;
                    // If there's land to the left, subtract 2 (shared edge counted twice)
                    if (c > 0 && grid[r][c - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}