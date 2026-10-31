class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) return 1;
        
        int[] trustScores = new int[n + 1];
        
        for (int[] pair : trust) {
            trustScores[pair[0]]--; // person trusts someone
            trustScores[pair[1]]++; // person is trusted by someone
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
