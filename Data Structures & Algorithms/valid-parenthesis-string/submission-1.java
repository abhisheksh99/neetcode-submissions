class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum possible open parentheses
        int maxOpen = 0;  // Maximum possible open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Treat '(' as an open parenthesis
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                // Treat ')' as a closing parenthesis
                minOpen--;
                maxOpen--;
            } else {
                // '*' can be treated as '(', ')' or ""
                minOpen--;  // Treat '*' as ')'
                maxOpen++;  // Treat '*' as '('
            }
            
            // If at any point, maxOpen becomes negative, it means there are too many ')'
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen should never be negative, as we cannot have unmatched ')' without '('
            minOpen = Math.max(minOpen, 0);
        }
        
        // If minOpen is 0, it means all '(' can be matched with ')'
        return minOpen == 0;
    }

}