
public class Solution {

    private List<String> res = new ArrayList<>();
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder cur) {
        if (index == digits.length()) {
            res.add(cur.toString());
            return;
        }

        String chars = map[digits.charAt(index) - '0'];
        for (char c : chars.toCharArray()) {
            cur.append(c);
            backtrack(digits, index + 1, cur);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }
    }

}