class NumMatrix {
    private int[][] prefixSum;

    // Constructor: Precompute prefix sums for the matrix
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSum = new int[rows + 1][cols + 1]; // Extra row and column as buffer for simpler logic

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                prefixSum[r][c] = matrix[r - 1][c - 1] 
                    + prefixSum[r - 1][c] 
                    + prefixSum[r][c - 1] 
                    - prefixSum[r - 1][c - 1]; 
            }
        }
    }

    // Return the sum of the sub-rectangle from (row1, col1) to (row2, col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1]
             - prefixSum[row1][col2 + 1]
             - prefixSum[row2 + 1][col1]
             + prefixSum[row1][col1];
    }
}
