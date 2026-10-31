class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Initialize the max values for each element in the triplet
        int[] maxValues = new int[3];

        // Iterate over each triplet
        for (int[] triplet : triplets) {
            // Check if the current triplet can contribute to the target
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                // Update the max values for each element
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }

        // Check if the max values match the target triplet
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }

}