class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can still add an opening bracket
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }

        // If we can add a closing bracket (only if there are unmatched opens)
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}
