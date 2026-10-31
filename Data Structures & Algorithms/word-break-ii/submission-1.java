class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        
        List<String> res = new ArrayList<>();
        
        if (s.isEmpty()) {
            res.add(""); // base case: empty string returns empty sentence
            return res;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixWays = backtrack(suffix, wordSet, memo);
                for (String way : suffixWays) {
                    if (way.isEmpty()) {
                        res.add(prefix);
                    } else {
                        res.add(prefix + " " + way);
                    }
                }
            }
        }
        
        memo.put(s, res);
        return res;
    }
}