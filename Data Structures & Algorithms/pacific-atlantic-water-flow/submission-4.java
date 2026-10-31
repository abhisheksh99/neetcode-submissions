public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(heights, pac, heights[0][c], 0, c);
            dfs(heights, atl, heights[ROWS - 1][c], ROWS - 1, c);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, pac, heights[r][0], r, 0);
            dfs(heights, atl, heights[r][COLS - 1], r, COLS - 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] h, boolean[][] seen, int prevHeight, int i, int j) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length)
            return;
        if (seen[i][j])
            return;
        if (h[i][j] < prevHeight)
            return;

        seen[i][j] = true;

        dfs(h, seen, h[i][j], i + 1, j);
        dfs(h, seen, h[i][j], i - 1, j);
        dfs(h, seen, h[i][j], i, j + 1);
        dfs(h, seen, h[i][j], i, j - 1);
    }
}
