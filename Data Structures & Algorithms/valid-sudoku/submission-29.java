class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char val = board[i][j];
                
                if (val == '.') {
                    continue;
                }

                // Check row
                if (rows[i].contains(val)) {
                    return false;
                }
                rows[i].add(val);

                // Check column
                if (cols[j].contains(val)) {
                    return false;
                }
                cols[j].add(val);

                // Check box
                int idx = (i / 3) * 3 + (j / 3);
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }

        return true;
    }
}