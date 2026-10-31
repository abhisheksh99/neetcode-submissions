class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            // Extract the last digit
            int pop = x % 10;
            x /= 10;
            
            // Check for overflow before actually updating the reversed number
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;  // Overflow case
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;  // Underflow case
            }
            
            // Update the reversed number
            rev = rev * 10 + pop;
        }
        
        return rev;
    }
}