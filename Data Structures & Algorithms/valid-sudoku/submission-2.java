class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Create arrays of HashSet for rows, columns, and boxes
        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        // Initialize each HashSet
        for (int r = 0; r < N; r++) {
            row[r] = new HashSet<Character>();
            col[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        // Iterate through the board
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (row[r].contains(val)) {
                    return false;
                }
                row[r].add(val);

                // Check the column
                if (col[c].contains(val)) {
                    return false;
                }
                col[c].add(val);

                // Calculate the box index
                int idx = (r / 3) * 3 + (c / 3);
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }

        // If no conflicts, the Sudoku is valid
        return true;
    }
}
