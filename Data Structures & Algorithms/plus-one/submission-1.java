class Solution {
     public static int[] plusOne(int[] digits) {
        // Start from the last digit and move leftward
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // No carry needed, just increment and return
                return digits;
            }
            // If the digit is 9, set it to 0 and continue to the next digit
            digits[i] = 0;
        }
        
        // If all digits were 9, we need a new array with an extra digit
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;  // The most significant digit is 1, rest are 0 by default
        return newDigits;
    }

}