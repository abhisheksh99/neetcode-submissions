class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int len : matchsticks) total += len;

        // If total length cannot form 4 equal sides, it's impossible
        if (total % 4 != 0) return false;

        int target = total / 4;

        // Sort descending for faster pruning
        Arrays.sort(matchsticks);

        return backtrack(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, target);
    }

    private boolean backtrack(int[] sticks, int index, int top, int bottom, int left, int right, int target) {
        // ✅ Base case: all sticks used
        if (index < 0)
            return top == target && bottom == target && left == target && right == target;

        int val = sticks[index];

        // 🔹 Prune if any side exceeds target
        if (top > target || bottom > target || left > target || right > target)
            return false;

        // Try placing current stick on each side
        if (backtrack(sticks, index - 1, top + val, bottom, left, right, target)) return true;
        if (backtrack(sticks, index - 1, top, bottom + val, left, right, target)) return true;
        if (backtrack(sticks, index - 1, top, bottom, left + val, right, target)) return true;
        if (backtrack(sticks, index - 1, top, bottom, left, right + val, target)) return true;

        return false;
    }
}