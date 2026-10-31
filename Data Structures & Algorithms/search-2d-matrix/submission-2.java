class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows (m) and columns (n) in the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Define the search boundaries for a virtual 1D array representation
        int left = 0; // Start of the virtual array
        int right = m * n - 1; // End of the virtual array

        // Perform binary search
        while (left <= right) {
            // Find the midpoint of the current search range
            int mid = (left + right) / 2;

            // Map the 1D mid index back to the 2D matrix using row and column indices
            int midValue = matrix[mid / n][mid % n];

            // Check if the midValue matches the target
            if (midValue == target) {
                return true; // Target found in the matrix
            } 
            // If midValue is less than the target, search in the right half
            else if (midValue < target) {
                left = mid + 1;
            } 
            // If midValue is greater than the target, search in the left half
            else {
                right = mid - 1;
            }
        }

        // If we exit the loop, the target is not in the matrix
        return false;
    }
}
